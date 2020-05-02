package top.elgong.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*
*
*   解决redis 用到的
* */
public class JedisService {

    /**
     *
     * @param key
     * @param value
     */
    public void set(String key, String value){
        Jedis resource = null;
        try{
            JedisPool jedisPool = JedisFactory.getJedisPool();

            resource = jedisPool.getResource();

            resource.set(key, value);

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            // 送回连接池中
            if (resource != null){
                resource.close();  // close 就是送回池子
            }
        }
    }

    /*
    *
    * */
    public String get(String key){
        Jedis resource = null;
        String ret = null;
        try{
            JedisPool jedisPool = JedisFactory.getJedisPool();
            resource = jedisPool.getResource();

            ret = resource.get(key);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 送回连接池中
            if (resource != null){
                resource.close();  // close 就是送回池子
            }
        }

        return ret;
    }

}
