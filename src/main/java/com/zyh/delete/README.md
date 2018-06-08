# Memcached delete 命令

Memcached delete 命令用于删除已存在的 key(键)。

**语法：**

delete 命令的基本语法格式如下：
```markdown
delete key [noreply]
```

多个 key 使用空格隔开，如下:
```markdown
delete key1 key2 key3
```

参数说明如下：

- **key**：键值 key-value 结构中的 key，用于查找缓存值。
- **noreply（可选）**： 该参数告知服务器不需要返回数据

**实例**

在以下实例中，我们使用 w3cschool 作为 key，过期时间设置为 900 秒。之后我们使用 delete 命令删除该 key。

```markdown
set w3cschool 0 900 9
memcached
STORED
get w3cschool
VALUE w3cschool 0 9
memcached
END
delete w3cschool
DELETED
get w3cschool
END
delete w3cschool
NOT_FOUND
```

**输出**

输出信息说明：

- **DELETED**：删除成功。
- **ERROR**：语法错误或删除失败。
- **NOT_FOUND**：key 不存在。