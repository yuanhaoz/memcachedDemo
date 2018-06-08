# Memcached 统计命令

## Memcached stats 命令

Memcached stats 命令用于返回统计信息例如 PID(进程号)、版本号、连接数等。

**语法：**

stats 命令的基本语法格式如下：
```markdown
stats
```

**实例**

在以下实例中，我们使用了 stats 命令来输出 Memcached 服务信息。

```markdown
stats
STAT pid 1162
STAT uptime 5022
STAT time 1415208270
STAT version 1.4.14
STAT libevent 2.0.19-stable
STAT pointer_size 64
STAT rusage_user 0.096006
STAT rusage_system 0.152009
STAT curr_connections 5
STAT total_connections 6
STAT connection_structures 6
STAT reserved_fds 20
STAT cmd_get 6
STAT cmd_set 4
STAT cmd_flush 0
STAT cmd_touch 0
STAT get_hits 4
STAT get_misses 2
STAT delete_misses 1
STAT delete_hits 1
STAT incr_misses 2
STAT incr_hits 1
STAT decr_misses 0
STAT decr_hits 1
STAT cas_misses 0
STAT cas_hits 0
STAT cas_badval 0
STAT touch_hits 0
STAT touch_misses 0
STAT auth_cmds 0
STAT auth_errors 0
STAT bytes_read 262
STAT bytes_written 313
STAT limit_maxbytes 67108864
STAT accepting_conns 1
STAT listen_disabled_num 0
STAT threads 4
STAT conn_yields 0
STAT hash_power_level 16
STAT hash_bytes 524288
STAT hash_is_expanding 0
STAT expired_unfetched 1
STAT evicted_unfetched 0
STAT bytes 142
STAT curr_items 2
STAT total_items 6
STAT evictions 0
STAT reclaimed 1
END
END
```

这里显示了很多状态信息，下边详细解释每个状态项：

- pid： memcache服务器进程ID
- uptime：服务器已运行秒数
- time：服务器当前Unix时间戳
- version：memcache版本
- pointer_size：操作系统指针大小
- rusage_user：进程累计用户时间
- rusage_system：进程累计系统时间
- curr_connections：当前连接数量
- total_connections：Memcached运行以来连接总数
- connection_structures：Memcached分配的连接结构数量
- cmd_get：get命令请求次数
- cmd_set：set命令请求次数
- cmd_flush：flush命令请求次数
- get_hits：get命令命中次数
- get_misses：get命令未命中次数
- delete_misses：delete命令未命中次数
- delete_hits：delete命令命中次数
- incr_misses：incr命令未命中次数
- incr_hits：incr命令命中次数
- decr_misses：decr命令未命中次数
- decr_hits：decr命令命中次数
- cas_misses：cas命令未命中次数
- cas_hits：cas命令命中次数
- cas_badval：使用擦拭次数
- auth_cmds：认证命令处理的次数
- auth_errors：认证失败数目
- bytes_read：读取总字节数
- bytes_written：发送总字节数
- limit_maxbytes：分配的内存总大小（字节）
- accepting_conns：服务器是否达到过最大连接（0/1）
- listen_disabled_num：失效的监听数
- threads：当前线程数
- conn_yields：连接操作主动放弃数目
- bytes：当前存储占用的字节数
- curr_items：当前存储的数据总数
- total_items：启动以来存储的数据总数
- evictions：LRU释放的对象数目
- reclaimed：已过期的数据条目来存储新数据的数目



## Memcached stats items 命令

Memcached stats items 命令用于显示各个 slab 中 item 的数目和存储时长(最后一次访问距离现在的秒数)。

**语法：**

stats items 命令的基本语法格式如下：
```markdown
stats items
```

**实例**

```markdown
stats items
STAT items:1:number 1
STAT items:1:age 7
STAT items:1:evicted 0
STAT items:1:evicted_nonzero 0
STAT items:1:evicted_time 0
STAT items:1:outofmemory 0
STAT items:1:tailrepairs 0
STAT items:1:reclaimed 0
STAT items:1:expired_unfetched 0
STAT items:1:evicted_unfetched 0
END
```



## Memcached stats slabs 命令

Memcached stats slabs 命令用于显示各个slab的信息，包括chunk的大小、数目、使用情况等。

**语法：**

stats slabs 命令的基本语法格式如下：
```markdown
stats slabs
```

**实例**

```markdown
stats slabs
STAT 1:chunk_size 96
STAT 1:chunks_per_page 10922
STAT 1:total_pages 1
STAT 1:total_chunks 10922
STAT 1:used_chunks 1
STAT 1:free_chunks 10921
STAT 1:free_chunks_end 0
STAT 1:mem_requested 71
STAT 1:get_hits 0
STAT 1:cmd_set 1
STAT 1:delete_hits 0
STAT 1:incr_hits 0
STAT 1:decr_hits 0
STAT 1:cas_hits 0
STAT 1:cas_badval 0
STAT 1:touch_hits 0
STAT active_slabs 1
STAT total_malloced 1048512
END
```



## Memcached stats sizes 命令

Memcached stats sizes 命令用于显示所有item的大小和个数。

该信息返回两列，第一列是 item 的大小，第二列是 item 的个数。

**语法：**

stats sizes 命令的基本语法格式如下：
```markdown
stats sizes
```

**实例**

```markdown
stats sizes
STAT 96 1
END
```



## Memcached flush_all 命令

Memcached flush_all 命令用于用于清理缓存中的所有 key=>value(键=>值) 对。
                    
该命令提供了一个可选参数 time，用于在制定的时间后执行清理缓存操作。

**语法：**

flush_all 命令的基本语法格式如下：
```markdown
flush_all [time] [noreply]
```

**实例**

清理缓存:

```markdown
set w3cschool 0 900 9
memcached
STORED
get w3cschool
VALUE w3cschool 0 9
memcached
END
flush_all
OK
get w3cschool
END
```
