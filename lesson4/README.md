# lesson 4
为什么要突破512字节？是因为BIOS最多只能操作512字节中的数据？

所以才需要先实现一个内核加载器来将真正的内核加载到内存中？


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