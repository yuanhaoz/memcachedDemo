package com.zyh.cas;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * cas 操作实例
 * Created by yuanhao on 6/8/18.
 */
public class Cas {

    public static void main(String[] args) {
        try {
            // 本地连接 ConnectServer 服务
            MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // 添加数据
            Future fo = memcachedClient.set("xjtu", 900, "You are best");
            // 输出执行 set 方法后的状态
            System.out.println("set status: " + fo.get());
            // 获取键对应的值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 通过 gets 方法获取 CAS token （令牌）
            CASValue casValue = memcachedClient.gets("xjtu");
            // 输出 CAS token （令牌）值
            System.out.println("CAS token - " + casValue);
            // 尝试使用 cas 方法更新数据
            CASResponse casResponse = memcachedClient.cas("xjtu", casValue.getCas(), 900, "You are still best");
            // 输出执行 CAS 响应信息
            System.out.println("CAS Response - " + casResponse);
            // 输出值
            System.out.println("xjtu value in cache - " + memcachedClient.get("xjtu"));

            // 关闭连接
            memcachedClient.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
