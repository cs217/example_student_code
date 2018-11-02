import spatial.dsl._


@spatial object GEMM extends SpatialApp {

  // Feel free to tweak this. You're under no obligation whatsoever to keep precisions anywhere as long as your final
  // result satisfies the requirements in GEMM.md
  type T = FixPt[TRUE, _10, _22]

  val M = 256
  val N = 512
  val K = 512

  override def main(args: Array[String]): Unit = {

    // Compute C (MxK) = A (MxN) x B (NxK)
    // MxN matrix
    val A_data = loadCSV2D[T]("A.csv")

    val A_DRAM = DRAM[T](M, N)
    setMem(A_DRAM, A_data)

    // NxK matrix
    val B_data = loadCSV2D[T]("B.csv")

    val B_DRAM = DRAM[T](N, K)
    setMem(B_DRAM, B_data)

    val C_DRAM = DRAM[T](M, K)

    Accel {
      // Perform Matrix Multiplication here
    }

    writeCSV2D(getMatrix(C_DRAM), "output.csv")
  }
}
