package top.elgong.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/*
*  jedis Test.
*
*     @author: elgong
*
* 一、 jedis 包的导入两种方式：
*
*    1. 直接手动导入：  file -》 project structure - 》 lib +
*
*    2. maven pox.xml
    <dependency>
        <groupId>redis.clients</groupId>
        <artifactId>jedis</artifactId>
        <version>3。1.0</version>
    </dependency>

* 二、 配置方式：两种
*
*   1. spring 框架下：
*
* 配置类-》 从application.preperties 读取配置项，并且配置
*       @Component
        @ConfigurationProperties(prefix = "redis")
        public class RedisConfig {

          .... 配置项
        }

poolFactory 工厂类创建 pool
        @Component
        public class RedisPoolFactory {
            @Autowired
            RedisConfig redisConfig;

            // Bean 注解根据方法创建对象，类型是JedisPool
            @Bean
            public JedisPool JedisPoolFactory(){

                JedisPoolConfig poolConfig = new JedisPoolConfig();
                poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
                poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
                poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxTotal()*1000);

                JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout()*1000, redisConfig.getPassword(), 0);

                return jedisPool;
        }


* Redis 服务类 开始封装各种服务
       * @Service
         public class RedisService {
            @Autowired
            JedisPool jedisPool;
         }

    2. 非spring 框架  （本代码就是）
    *
    * 单例模式。。 + 线程安全

*
*
*
* */
public class JedisFactory {

    private volatile  static JedisPool jedisPool;

    private volatile static JedisPoolConfig poolConfig;
    private volatile static String ip;
    private volatile static int port;
    private volatile static int timeout;
    private volatile static String password;
    private volatile static int database;

    private JedisFactory() {

        //JedisPoolConfig poolConfig, String ip, int port, int timeout, String password, int database
        /* apache common-pool 工具
        *
        * JedisPoolConfig
        * */
        this.jedisPool = new JedisPool(poolConfig, ip, port, timeout , password, 0);
    }


    public static JedisPool getJedisPool(){

        if (jedisPool == null){

            synchronized (JedisFactory.class){

                if (jedisPool == null){
                    jedisPool = new JedisPool(JedisFactory.poolConfig, JedisFactory.ip, JedisFactory.port,
                                              JedisFactory.timeout,  JedisFactory.password, JedisFactory.database);
                }
            }
        }

        return jedisPool;
    }

    public static void setJedisPoolConfig(JedisPoolConfig poolConfig, String ip, int port, int timeout, String password, int database){

        System.out.println(" 配置jedis 参数...");
        JedisFactory.poolConfig = poolConfig;
        JedisFactory.ip = ip;
        JedisFactory.port = port;
        JedisFactory.timeout = timeout * 1000;
        JedisFactory.password = password;
        JedisFactory.database = database;

    }
}
