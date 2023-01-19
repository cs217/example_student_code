# Programming Assignment 1 - GEMV
Before reading this document, you should have first read the README.

In this project, you will be implementing a Matrix-Vector multiply using Spatial. The inputs will be fed in through `matrix.csv` and `vector.csv`, and an output will be returned through `output.csv`. These can be generated via python with numpy, or other methods, and should be placed in the `gen/GEMV` folder after running `make` and before `bash run.sh`. A simple skeleton has been written for you in `src/main/scala/GEMV.scala`

You will need to provide the matrix and vector files yourself. Each element of the inputs are guaranteed to be in the interval `[-1, 1]`.

## Constraints
Your final design should only use fixed point operations, and take fewer than 200 ops, and 64 kibibytes of combined SRAM and registers. Your result should be accurate with an l2-norm of 0.02

