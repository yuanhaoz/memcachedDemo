package com.zyh.set;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * set 操作实例
 * 以下使用 java.util.concurrent.Future 来存储数据
 * Created by yuanhao on 6/8/18.
 */
public class Set {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 存储数据
            Future fo = memcachedClient.set("xjtu", 900, "You are best");
            // 查看状态
            System.out.println("set status: " + fo.get());
            // 输出值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
