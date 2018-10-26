# Programming Assignment 1 - GEMV
Before reading this document, you should have first read the README.

In this project, you will be implementing a Matrix-Vector multiply using Spatial. The inputs will be fed in through `matrix.csv` and `vector.csv`, and an output will be returned through `output.csv`. These can be generated via python with numpy, or other methods, and should be placed in the `gen/GEMV` folder after running `make` and before `bash run.sh`. A simple skeleton has been written for you in `src/main/scala/GEMV.scala`


## Constraints
Your final design should only use fixed point operations, and take fewer than 200 ops, and 64 kibibytes of combined SRAM and registers.

## Deadline
This project will be due on 11/6. The intent of this project is to familiarize yourself with Spatial as well as area/performance tuning.
