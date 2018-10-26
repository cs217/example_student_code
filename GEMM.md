# Programming Assignment 2 - GEMM
Before reading this document, you should have first read the README.

In this project, you will be implementing a Matrix-Matrix multiply using Spatial. The inputs will be fed in through `A.csv` and `B.csv`, and an output will be returned through `C.csv`. These can be generated via python with numpy, or other methods, and should be placed in the `gen/GEMV` folder after running `make` and before `bash run.sh`. A simple skeleton has been written for you in `src/main/scala/GEMM.scala`


## Constraints
Your final design should only use fixed point operations, and take fewer than 512 ops, and 64 kibibytes of combined SRAM and registers.
Note that you are free to change all of the precisions involved as long as your final program remains within 1% (l2-norm, max-norm) of the double-precision result.

## Deadline
This project will be due on 11/6. The intent of this project is to familiarize yourself with Spatial as well as area/performance tuning.
