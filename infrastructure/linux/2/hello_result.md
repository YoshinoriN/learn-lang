## Cの場合

```sh
$ strace -o hello_result ./hello
```

```
// 結果

execve("./hello", ["./hello"], 0x7fffe505f620 /* 17 vars */) = 0
brk(NULL)                               = 0x7fffcbf0b000
access("/etc/ld.so.nohwcap", F_OK)      = -1 ENOENT (No such file or directory)
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory)
openat(AT_FDCWD, "/etc/ld.so.cache", O_RDONLY|O_CLOEXEC) = 3
fstat(3, {st_mode=S_IFREG|0644, st_size=40922, ...}) = 0
mmap(NULL, 40922, PROT_READ, MAP_PRIVATE, 3, 0) = 0x7f27bc6e0000
close(3)                                = 0
access("/etc/ld.so.nohwcap", F_OK)      = -1 ENOENT (No such file or directory)
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libc.so.6", O_RDONLY|O_CLOEXEC) = 3
read(3, "\177ELF\2\1\1\3\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\260\34\2\0\0\0\0\0"..., 832) = 832
fstat(3, {st_mode=S_IFREG|0755, st_size=2030544, ...}) = 0
mmap(NULL, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7f27bc6d0000
mmap(NULL, 4131552, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f27bc000000
mprotect(0x7f27bc1e7000, 2097152, PROT_NONE) = 0
mmap(0x7f27bc3e7000, 24576, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1e7000) = 0x7f27bc3e7000
mmap(0x7f27bc3ed000, 15072, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7f27bc3ed000
close(3)                                = 0
arch_prctl(ARCH_SET_FS, 0x7f27bc6d14c0) = 0
mprotect(0x7f27bc3e7000, 16384, PROT_READ) = 0
mprotect(0x7f27bca00000, 4096, PROT_READ) = 0
mprotect(0x7f27bc627000, 4096, PROT_READ) = 0
munmap(0x7f27bc6e0000, 40922)           = 0
fstat(1, {st_mode=S_IFCHR|0660, st_rdev=makedev(4, 1), ...}) = 0
ioctl(1, TCGETS, {B38400 opost isig icanon echo ...}) = 0
brk(NULL)                               = 0x7fffcbf0b000
brk(0x7fffcbf2c000)                     = 0x7fffcbf2c000
write(1, "Helloooooooo!!!!\n", 17)      = 17   // writeシステムコールにより出力された
exit_group(0)                           = ?
+++ exited with 0 +++
```

## Pythonの場合

```sh
$ strace -o hello.py.log python hello.py
```

```sh
execve("/usr/bin/python", ["python", "hello.py"], 0x7fffff68d0c8 /* 17 vars */) = 0
brk(NULL)                               = 0x7fffbdce8000
access("/etc/ld.so.nohwcap", F_OK)      = -1 ENOENT (No such file or directory)
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory)

...長いので略

fstat(1, {st_mode=S_IFCHR|0660, st_rdev=makedev(4, 1), ...}) = 0
ioctl(1, TCGETS, {B38400 opost isig icanon echo ...}) = 0
write(1, "hello python!!!\n", 16)       = 16                  // writeシステムコール
rt_sigaction(SIGINT, {sa_handler=SIG_DFL, sa_mask=[], sa_flags=SA_RESTORER, sa_restorer=0x7f612fa3ef20}, {sa_handler=0x7f6130369dd0, sa_mask=[], sa_flags=SA_RESTORER, sa_restorer=0x7f612fa3ef20}, 8) = 0
brk(0x7fffbddb5000)                     = 0x7fffbddb5000
exit_group(0)                           = ?
+++ exited with 0 +++
```

## システムコール実行時間

`$ strace -T`

```
execve("./hello", ["./hello"], 0x7fffdc705e38 /* 18 vars */) = 0 <0.006368>
brk(NULL)                               = 0x7fffea0e4000 <0.000027>
access("/etc/ld.so.nohwcap", F_OK)      = -1 ENOENT (No such file or directory) <0.000127>
access("/etc/ld.so.preload", R_OK)      = -1 ENOENT (No such file or directory) <0.000142>
openat(AT_FDCWD, "/etc/ld.so.cache", O_RDONLY|O_CLOEXEC) = 3 <0.000149>
fstat(3, {st_mode=S_IFREG|0644, st_size=40922, ...}) = 0 <0.000054>
mmap(NULL, 40922, PROT_READ, MAP_PRIVATE, 3, 0) = 0x7f2eb4446000 <0.000080>
close(3)                                = 0 <0.000019>
access("/etc/ld.so.nohwcap", F_OK)      = -1 ENOENT (No such file or directory) <0.000049>
openat(AT_FDCWD, "/lib/x86_64-linux-gnu/libc.so.6", O_RDONLY|O_CLOEXEC) = 3 <0.000124>
read(3, "\177ELF\2\1\1\3\0\0\0\0\0\0\0\0\3\0>\0\1\0\0\0\260\34\2\0\0\0\0\0"..., 832) = 832 <0.000032>
fstat(3, {st_mode=S_IFREG|0755, st_size=2030544, ...}) = 0 <0.000022>
mmap(NULL, 8192, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_ANONYMOUS, -1, 0) = 0x7f2eb4440000 <0.000028>
mmap(NULL, 4131552, PROT_READ|PROT_EXEC, MAP_PRIVATE|MAP_DENYWRITE, 3, 0) = 0x7f2eb3e00000 <0.000064>
mprotect(0x7f2eb3fe7000, 2097152, PROT_NONE) = 0 <0.000023>
mmap(0x7f2eb41e7000, 24576, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_DENYWRITE, 3, 0x1e7000) = 0x7f2eb41e7000 <0.000053>
mmap(0x7f2eb41ed000, 15072, PROT_READ|PROT_WRITE, MAP_PRIVATE|MAP_FIXED|MAP_ANONYMOUS, -1, 0) = 0x7f2eb41ed000 <0.000033>
close(3)                                = 0 <0.000036>
arch_prctl(ARCH_SET_FS, 0x7f2eb44414c0) = 0 <0.000018>
mprotect(0x7f2eb41e7000, 16384, PROT_READ) = 0 <0.000025>
mprotect(0x7f2eb4800000, 4096, PROT_READ) = 0 <0.000021>
mprotect(0x7f2eb4427000, 4096, PROT_READ) = 0 <0.000021>
munmap(0x7f2eb4446000, 40922)           = 0 <0.000045>
fstat(1, {st_mode=S_IFCHR|0660, st_rdev=makedev(4, 1), ...}) = 0 <0.000023>
ioctl(1, TCGETS, {B38400 opost isig icanon echo ...}) = 0 <0.000018>
brk(NULL)                               = 0x7fffea0e4000 <0.000018>
brk(0x7fffea105000)                     = 0x7fffea105000 <0.000033>
write(1, "Helloooooooo!!!!\n", 17)      = 17 <0.000213>
exit_group(0)                           = ?
+++ exited with 0 +++
```
