package com.zyh.add;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * add 操作实例
 * Created by yuanhao on 6/8/18.
 */
public class Add {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 存储数据
            Future fo = memcachedClient.set("xjtu", 900, "You are best");
            // 打印状态
            System.out.println("set status: " + fo.get());
            // 输出
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 添加新key
            fo = memcachedClient.add("xian", 900, "good city");
            // 打印状态
            System.out.println("add status: " + fo.get());
            // 输出
            System.out.println("xian value in cache - " + memcachedClient.get("xian"));

            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
