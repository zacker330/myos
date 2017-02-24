# lesson 3


### compile and import system.img into Virtualbox
```
nasm -o boot.bat boot.asm
```

```
javac Floppy.java OperatingSystem.java && java OperatingSystem
```


### modify & recomplie

```
rm boot.bat system.img *.class && nasm -o boot.bat boot.asm && javac Floppy.java OperatingSystem.java && java OperatingSystem
```