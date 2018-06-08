package com.zyh.incrAndDecr;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * incr / Decr 操作实例
 * Created by yuanhao on 6/8/18.
 */
public class IncrAndDecr {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 添加数据
            Future fo = memcachedClient.set("xjtu", 900, "1000");
            // 输出执行 set 方法后的状态
            System.out.println("set status: " + fo.get());
            // 获取键对应的值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 自增并输出
            System.out.println("xjtu value in cache after increment: " + memcachedClient.incr("xjtu", 111));
            // 自减并输出
            System.out.println("xjtu value in cache after decrement: " + memcachedClient.decr("xjtu", 112));

            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
