package com.xuhu.cloud.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

/**
 * springboot 1.x
 * redis缓存服务器配置
 */
//@EnableCaching
//@Configuration
public class RedisConfig1 extends CachingConfigurerSupport {

    /*
    @Bean
    public KeyGenerator acctKeyGenerator() {
        return (Object target, Method method, Object... params) -> {
            StringBuilder buff = new StringBuilder();
            buff.append(target.getClass().getSimpleName());
            buff.append(method.getName());
            for (Object obj : params) {
                buff.append(obj.toString());
            }
            return buff.toString();
        };
    }


    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProp.getHost());
        factory.setPort(redisProp.getPort());
        factory.setTimeout(redisProp.getTimeout());
        factory.setPassword(redisProp.getPassword());
        factory.setDatabase(redisProp.getDatabase());

        factory.setUsePool(true);
        factory.setPoolConfig(redisPoolConfig());

        return factory;
    }

    */

    /*
    @Bean
    public JedisPoolConfig redisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(redisProp.getPoolMinIdle());
        jedisPoolConfig.setMaxIdle(redisProp.getPoolMaxIdle());
        jedisPoolConfig.setMaxTotal(redisProp.getPoolMaxActive());
        jedisPoolConfig.setMaxWaitMillis(redisProp.getPoolMaxWait());
        jedisPoolConfig.setTestOnBorrow(redisProp.getPoolTestOnBorrow());
        return jedisPoolConfig;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();

        return template;
    }

    */


    /**
     * 配置CacheManager 管理cache
     * @return
     */

    /*
    @Bean
    @Override
    public CacheManager cacheManager() {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
        // 设置key-value超时时间s
        cacheManager.setDefaultExpiration(60*60);
        return cacheManager;
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        return new MyCacheErrorHandler();
    }

    public class MyCacheErrorHandler implements CacheErrorHandler {

        private Logger logger = LoggerFactory.getLogger(MyCacheErrorHandler.class);

        @Override
        public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
            logger.error("获取redis缓存异常,redis.key:{},cacheName:{}", o, cache.getName());
            return;
        }

        @Override
        public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
            logger.error("获取redis缓存异常,redis.key:{},cacheName:{}", o, cache.getName());
            return;
        }

        @Override
        public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
            throw e;
        }

        @Override
        public void handleCacheClearError(RuntimeException e, Cache cache) {
            throw e;
        }
    }

    */
}


