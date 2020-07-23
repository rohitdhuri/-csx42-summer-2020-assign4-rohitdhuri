# CSX42: Assignment 4
## Name: Rohit Mahendra Dhuri

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on this project.


Note: build.xml is present in [arrayVisitors/src](./arrayVisitors/src/) folder.

## Instruction to clean:

```commandline
ant -buildfile arrayVisitors/src/build.xml all
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile arrayVisitors/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile arrayVisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dcommonintsout="commonintsout.txt" -Dmissingintsout="missingintsout.txt" -Ddebug="debugLevel"
```
Note: Arguments accept the absolute path of the files.

## Description:
1. Assumption: 
Absolute path of the input files is provided.
All the operations that need to be performed are according to the given input format.
All integers are two or less than two digit integers.

2. Data Structures: 
Strings have been used as output buffers.
Arrays have been used for storing integers and also for storing instances.
Sets have been used for storing results for operations in visitors.

3. Code Working: 
Program accpets 5 arguments.
Input file name is passed to a visitor which populates the array element by reading one line at a time.
Another element holds the multiple instances of these arrays.
A visitor finds the common integers in these arrays and stores them in results.
A visitor finds the missing integers in all the arrasy and stores them in results.

5. Slack days: 
Used one slack day.

## Academic Honesty statement:

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [07/23/2020]
