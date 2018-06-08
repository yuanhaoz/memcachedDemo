package com.zyh.connect;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;

/**
 * 使用 Java 程序连接 ConnectServer，需要在你的 classpath 中添加 ConnectServer jar 包。
 * 以下程序假定 ConnectServer 服务的主机为 127.0.0.1，端口为 11211。
 *
 * Created by yuanhao on 6/8/18.
 */
public class ConnectServer {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");
            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
