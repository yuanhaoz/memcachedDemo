# Memcached 学习

## Memcached 运行

Memcached命令的运行：
```markdown
/usr/local/memcached/bin/memcached -d -m 64M -u root -l 127.0.0.1 -p 11211 -c 256 -P /tmp/memcached.pid
```

注意：如果使用自动安装 memcached 命令位于 /usr/local/bin/memcached。

启动选项：
- -d是启动一个守护进程；
- -m是分配给Memcache使用的内存数量，单位是MB；
- -u是运行Memcache的用户；
- -l是监听的服务器IP地址，可以有多个地址；
- -p是设置Memcache监听的端口，，最好是1024以上的端口；
- -c是最大运行的并发连接数，默认是1024；
- -P是设置保存Memcache的pid文件。

## Memcached 连接

我们可以通过 telnet 命令并指定主机ip和端口来连接 Memcached 服务。

**语法**
```markdown
telnet HOST PORT
```
命令中的 **HOST** 和 **PORT** 为运行 Memcached 服务的 IP 和 端口。

## Memcache 存储命令

- Memcached - set 命令 <a href="src/main/java/com/zyh/set"  target="_blank">前往</a>
- Memcached - add 命令 <a href="src/main/java/com/zyh/add"  target="_blank">前往</a>
- Memcached - replace 命令 <a href="src/main/java/com/zyh/replace"  target="_blank">前往</a>
- Memcached - append 命令 <a href="src/main/java/com/zyh/append"  target="_blank">前往</a>
- Memcached - prepend 命令 <a href="src/main/java/com/zyh/prepend"  target="_blank">前往</a>
- Memcached - cas 命令 <a href="src/main/java/com/zyh/cas"  target="_blank">前往</a>

## Memcache 查找命令

- Memcached - get 命令 <a href="src/main/java/com/zyh/get"  target="_blank">前往</a>
- Memcached - gets 命令 <a href="src/main/java/com/zyh/gets"  target="_blank">前往</a>
- Memcached - delete 命令 <a href="src/main/java/com/zyh/delete"  target="_blank">前往</a>
- Memcached - incr 与 decr 命令 <a href="src/main/java/com/zyh/incrAndDecr"  target="_blank">前往</a>

## Memcache 统计命令 

<a href="src/main/java/com/zyh/stats"  target="_blank">详情</a>

- Memcached - stats 命令 
- Memcached - stats items 命令
- Memcached - stats slabs 命令
- Memcached - stats sizes 命令
- Memcached -flush_all 命令