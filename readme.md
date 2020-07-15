
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