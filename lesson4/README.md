# lesson 4
在实现操作系统的时候，需要先实现一个操作系统的内核加载器，硬件先读取这个加载器，然后加载器再加载操作系统。

为什么要突破512字节？是因为BIOS最多只能操作512字节中的数据？

我理解是这样：

因为BIOS启动CPU时，CPU只加载512字节到内存中，剩下的就不管了。但是我们的操作系统不可能只有512字节，因为那样能干的事情太少了。
所以我们就想出了内存加载器这样的东西，它会负责告诉CPU下一步，你应该执行这个地址下的内容了。


### compile and import system.img into Virtualbox
```
nasm -o boot.bat boot.asm && nasm -o kernel.bat kernel.asm
```

```
javac Floppy.java OperatingSystem.java && java OperatingSystem
```


### modify & recomplie

```
rm *.bat system.img *.class && nasm -o boot.bat boot.asm && nasm -o kernel.bat kernel.asm && javac Floppy.java OperatingSystem.java && java OperatingSystem
```