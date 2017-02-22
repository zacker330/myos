# Lesson2
BLOG: http://blog.csdn.net/tyler_download/article/details/51761750

### 汇编如何调用BIOS的功能
`int` 是指调用BIOS的某个库函数。但是怎么向这些库函数传参数呢？你需要的是将这些参数传到到这些函数指定的CPU寄存器中就可以了。类似这段代码：

```
    mov al, [si]  -> 将si指向的内容放入到al寄存器中
    .... 省略
    mov ah, 0x0e -> 将0x0e放到ah寄存器中
    mov bx, 15 -> 将15放到bx寄存器中 -> 15表示颜色值
    int 0x10
    .... 省略
```

## compile boot.asm
```
% nasm -o boot.bat boot.asm                                                           ✭
boot.asm:22: warning: uninitialised space declared in .text section: zeroing
```
you can ignore warning here.

## compile & run java class

```shell
javac OperatingSystem.java && java OperatingSystem
```

## import the image that exported into virtualbox 

