package com.leo.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public class JedisUtils {

    private static JedisPool jedisPool;

    static {

        // 读取配置文件
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String host = pro.getProperty("host");
        String port = pro.getProperty("port");
        String maxTotal = pro.getProperty("maxTotal");
        String maxIdle = pro.getProperty("maxIdle");

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(maxTotal));
        config.setMaxIdle(Integer.parseInt(maxIdle));

        jedisPool = new JedisPool(config, host, Integer.parseInt(port));
    }

    /**
     * 获取Jedis
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }


}
