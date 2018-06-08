# Memcached replace 命令

Memcached replace 命令用于替换已存在的 **key(键)** 的 **value(数据值)**。

如果 key 不存在，则替换失败，并且您将获得响应 **NOT_STORED**。

**语法：**

replace 命令的基本语法格式如下：
```markdown
replace key flags exptime bytes [noreply] 
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

以下实例中我们设置：
- key → mykey
- flag → 0
- exptime → 900 (以秒为单位)
- bytes → 10 (数据存储的字节数)
- value → data_value

以下实例中我们使用的键位 'mykey' 并存储对应的值 data_value。执行后我们替换相同的 key 的值为 'some_other_value'。

```markdown
add mykey 0 900 10
data_value
STORED
get mykey
VALUE mykey 0 10
data_value
END
replace mykey 0 900 16
some_other_value
get mykey
VALUE mykey 0 16
some_other_value
END
```

**输出**

如果数据添加成功，则输出：
```markdown
STORED
```

输出信息说明：

- STORED：保存成功后输出。
- NOT_STORED：在保持失败后输出。