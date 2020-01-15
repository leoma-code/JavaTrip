package com.leo.redis;

import com.leo.redis.utils.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Leo on 2020/1/14.
 * Description :
 */
public class JedisTest {

    @Test
    public void testJedisUtils() {

        JedisUtils.getJedis().set("name", "Lucy");

        String name = JedisUtils.getJedis().get("name");
        System.out.println(name);

    }


    /**
     * Jedis连接池的使用
     */
    @Test
    public void test4() {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

//        JedisPool jedisPool = new JedisPool(config, "localhost");


        JedisPool jedisPool = new JedisPool();

        Jedis jedis = jedisPool.getResource();

        jedis.set("name", "TOM");

        System.out.println(jedis.get("name"));

        jedis.close();
    }


    @Test
    public void test3() {
        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // list 存储
        jedis.lpush("mylist", "a", "b", "c");//从左边存
        jedis.rpush("mylist", "a", "b", "c");//从右边存

        // list 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String element1 = jedis.lpop("mylist");//c
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");//c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);

        //3. 关闭连接
        jedis.close();
    }


    @Test
    public void test2() {

        //1. 获取连接
        Jedis jedis = new Jedis();//如果使用空参构造，默认值 "localhost",6379端口
        //2. 操作
        // 存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "female");
        // 获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);
        // 获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        // keyset
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        //3. 关闭连接
        jedis.close();

    }

    @Test
    public void test1() {

//        Jedis jedis = new Jedis("localhost", 6379);
        Jedis jedis = new Jedis();
        jedis.set("name", "Tom");

        System.out.println(jedis.get("name"));

        jedis.close();
    }


}
