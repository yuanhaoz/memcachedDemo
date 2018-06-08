# Memcached prepend 命令

Memcached prepend 命令用于向已存在 **key(键)** 的 **value(数据值)** 前面追加数据 。

**语法：**

prepend 命令的基本语法格式如下：
```markdown
prepend key flags exptime bytes [noreply] 
value 
```

参数说明如下：
- **key**：键值 key-value 结构中的 key，用于查找缓存值。
- **flags**：可以包括键值对的整型参数，客户机使用它存储关于键值对的额外信息。
- **exptime**：在缓存中保存键值对的时间长度（以秒为单位，0 表示永远）
- **bytes**：在缓存中存储的字节数
- **noreply（可选）**： 该参数告知服务器不需要返回数据
- **value**：存储的值（始终位于第二行）（可直接理解为key-value结构中的value）

**实例**

实例如下：

- 首先我们在 Memcached 中存储一个键 w3cschool，其值为 memcached。
- 然后，我们使用 get 命令检索该值。
- 然后，我们使用 prepend 命令在键为 w3cschool 的值后面追加 "redis"。
- 最后，我们再使用 get 命令检索该值。

```markdown
set w3cschool 0 900 9
memcached
STORED
get w3cschool
VALUE w3cschool 0 14
memcached
END
prepend w3cschool 0 900 5
redis
STORED
get w3cschool
VALUE w3cschool 0 14
redismemcached
END
```

**输出**

如果数据添加成功，则输出：
```markdown
STORED
```

输出信息说明：

- STORED：保存成功后输出。
- NOT_STORED：该键在 Memcached 上不存在。
- CLIENT_ERROR：执行错误。