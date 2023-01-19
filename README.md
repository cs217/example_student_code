# General Readme for Projects
This document will be updated as necessary, and contains the instructions necessary to run all programming assignments.

## Getting Spatial
Spatial is currently supported in Linux/Unix (Ubuntu). For this class, we will be using the CS217 branch of Spatial, available at https://github.com/stanford-ppl/spatial/tree/CS217

You will also need Scala, available through https://www.scala-lang.org/download/.
In order to run Spatial you will need the Integer Set Library (ISL, available on brew and apt-get, among others)

## Setup
Setting up the CS217 branch of Spatial:

```shell
git clone git@github.com:stanford-ppl/spatial.git
git fetch
git checkout CS217

bash bin/update_resources.sh
make publish
```

In order to update Spatial

```shell
make clean
make publish
```

## Manually Running Spatial Applications
A variety of applications are already written in Spatial. A tutorial, documentation, and other resources can be found at https://spatial-lang.org/.

In order to run an application from this directory:

```shell
TEST_DATA_HOME=$PWD/testData sbt -Dtest.CS217=true "; testOnly <appname>" 
```

## Counting Resources
After running your application, artifacts will be generated into `gen/CS217/<appname>`. The most important files are:
`SimulatedExecutionSummary_*.log`, which captures the cycle count and trip count of each controller, `info/PostExecution.html` which contains an html-based information dump, and `reports/Main.json`
which contains the resource utilization of your application. We have provided a python script `computeResourceUtilization.py` which summarizes the resource utilization in a more concise manner.
**Memory sizes in this output are given in bits, not bytes**


## Grading and evaluation
Each of you should have created your own Github repository via the classroom link. Refer to the corresponding markdown docs for assignment specific instructions.

In your repository, you should have a file named `identity.txt` containing your SUID and name.

## Getting Help
If you have general setup help, feel free to ping Nathan (stanfurd@) on Slack, or make a post on Ed Discussion. Help will also be available during Nathan's office hours.