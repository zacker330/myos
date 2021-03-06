org 0x7c00;

jmp entry
db 0x90
DB "OSKERNEL"
DW 512
DB 1
DW 1
DB 2
DW 224
DW 2880
DB 0XF0
DW 9
DW 18
DW 2
DD 0
DD 2880
DB 0,0,0X29
DD 0xFFFFFFFF
DB "MYFIRSTOS"
DB "FAT12"
RESB 18

entry:
    mov ax, 0
    mov ss, ax
    mov ds, ax
    mov es, ax
    mov si, msg

putloop:
    mov al, [si]
    add si, 1
    cmp al, 0
    je fin
    mov ah, 0x0e
    mov bx, 15
    int 0x10
    jmp putloop

fin:
    HLT
    jmp fin

msg:
    DB 0x0a, 0x0a
    db "hello, world"
    db 0x0a
    db 0