# Memcached get 命令

Memcached get 命令获取存储在 **key(**键) 中的 **value(数据值)** ，如果 key 不存在，则返回空。

**语法：**

get 命令的基本语法格式如下：
```markdown
get key
value 
```

多个 key 使用空格隔开，如下:
```markdown
get key1 key2 key3
```

参数说明如下：

- **key**：键值 key-value 结构中的 key，用于查找缓存值。

**实例**

在以下实例中，我们使用 w3cschool 作为 key，过期时间设置为 900 秒。

```markdown
set w3cschool 0 900 9
memcached
STORED
get w3cschool
VALUE w3cschool 0 9
memcached
END
```