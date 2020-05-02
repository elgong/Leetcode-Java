package top.elgong.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.time.LocalDateTime;

public class Test {

    public static JedisService jedisService = new JedisService();
    public static void main(String[] args) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        String ip = "121.41.111.45";
        int port = 6379;
        int timeout = 300;
        String password = "Gelqq666%";
        int database = 0;

        JedisFactory.setJedisPoolConfig(poolConfig, ip, port, timeout, password, database);

        jedisService.set("leetcode-java:jedis:test:key1", "haha-" + LocalDateTime.now().toString());

        String s = jedisService.get("leetcode-java:jedis:test:key1");

        System.out.println(s);
    }
}
