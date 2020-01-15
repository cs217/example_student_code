# General Readme for Projects
This document will be updated as necessary, and contains the instructions necessary to run all programming assignments.

## Getting Spatial
Spatial is currently supported in Mac and Linux/Unix (Ubuntu).

You will also need Scala, available through https://www.scala-lang.org/download/. Note: Scala is currently supported on JDK 8, and breaks on the latest versions.

In order to run Spatial you will need the Integer Set Library (ISL, available on brew and apt-get, among others)


## Manually Running Spatial Applications
A variety of applications are already written in Spatial. A tutorial, documentation, and other resources can be found at https://spatial-lang.org/.

For your applications living under this repository, simply run `sbt` to start a SBT console, followed by `runMain <appname> --sim` to convert your Spatial into regular Scala. `cd gen/<appname> && make` followed by `bash run.sh` to run the program.

## Grading and evaluation
Each of you should have created your own Github repository via the classroom link. Refer to the `GEMV.md` doc for assignment specific instructions. By pushing to the `master` branch, our autograder will pick up your code and generate a resource count and cycle estimates. This will execute at most every hour, but may be longer between runs depending on the number of simultaneous student submissions.

In your repository, you should have a file named `identity.txt` containing your SUID and name.
