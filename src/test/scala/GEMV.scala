import spatial.dsl._

@spatial class GEMV extends SpatialTest {

  type T = FixPt[TRUE,_10,_22]

  val N = 1024  // A is NxN, and x is N wide.

  def main(args: Array[String]): Unit = {

    // These are on the HOST
    val x_host = loadCSV1D[T](s"$DATA/vector.csv")
    val A_host = loadCSV2D[T](s"$DATA/matrix.csv")
    val A_dram = DRAM[T](N, N)
    val x_dram = DRAM[T](N)
    setMem(A_dram, A_host)
    setMem(x_dram, x_host)
    val out_host = DRAM[T](N)
    Accel {
      val A_sram = SRAM[T](N, N)
      val x_sram = SRAM[T](N)

      A_sram load A_dram
      x_sram load x_dram

      val out_sram = SRAM[T](N)
      Foreach(0 until N) {
        i =>
          val accum = Reg[T]
          Reduce(accum)(0 until N) {
            j => A_sram(i, j) * x_sram(j)
          } {_ + _}
          out_sram(i) = accum.value
      }
      out_host store out_sram
    }

    writeCSV1D(getMem(out_host), s"$DATA/output.csv")
    assert(Bit(true))
  }
}
