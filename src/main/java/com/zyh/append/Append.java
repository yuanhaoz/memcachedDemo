package com.zyh.append;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * append 操作实例
 * Created by yuanhao on 6/8/18.
 */
public class Append {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 添加数据
            Future fo = memcachedClient.set("xjtu", 900, "You are best");
            // 输出执行set方法后的状态
            System.out.println("set status: " + fo.get());
            // 获取键对应的值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 对存在的key进行数据添加操作
            fo = memcachedClient.append("xjtu", "You are still best");
            // 输出执行 append 方法后的状态
            System.out.println("append status: " + fo.get());
            // 获取键对应的值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
