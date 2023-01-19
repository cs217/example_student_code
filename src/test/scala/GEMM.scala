
import spatial.dsl._


@spatial class GEMM extends SpatialTest {

  // Feel free to tweak this. You're under no obligation whatsoever to keep precisions anywhere as long as your final
  // result satisfies the requirements in GEMM.md
  type T = FixPt[TRUE, _10, _22]

  val M = 128
  val N = 128
  val K = 128

  override def main(args: Array[String]): Unit = {

    // Compute C (MxK) = A (MxN) x B (NxK)
    // MxN matrix
    val A_data = loadCSV2D[T](s"$DATA/A.csv")

    val A_DRAM = DRAM[T](M, N)
    setMem(A_DRAM, A_data)

    // NxK matrix
    val B_data = loadCSV2D[T](s"$DATA/B.csv")

    val B_DRAM = DRAM[T](N, K)
    setMem(B_DRAM, B_data)

    val C_DRAM = DRAM[T](M, K)

    Accel {
      // Perform Matrix Multiplication here
      val A_SRAM = SRAM[T](M, N)
      val B_SRAM = SRAM[T](N, K)
      val C_SRAM = SRAM[T](M, K)
      A_SRAM load A_DRAM
      B_SRAM load B_DRAM
      Foreach(0 until M, 0 until K) {
        (m, k) =>
          val accum = Reg[T]
          Reduce(accum)(0 until N) {
            n =>
              A_SRAM(m, n) * B_SRAM(n, k)
          }{_ + _}
          C_SRAM(m, k) = accum.value
      }
      C_DRAM store C_SRAM
    }

    writeCSV2D(getMatrix(C_DRAM), s"$DATA/C.csv")
    assert(Bit(true))
  }
}