package com.xuhu.cloud.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.exception.ExceptionUtils;
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
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * redis缓存服务器配置
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConnectionFactory connectionFactory;

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
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = getJackson2JsonRedisSerializer();
        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();

        return template;
    }

    private Jackson2JsonRedisSerializer getJackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);
        return serializer;
    }


    /**
     * 配置CacheManager 管理cache
     * @return
     */
//    @Bean
//    @Override
//    public CacheManager cacheManager() {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(1));
//
//        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        valueSerializer.setObjectMapper(mapper);
//
//        StringRedisSerializer keySerializer = new StringRedisSerializer();
//
//        config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer));
//        config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer));
//
////        RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
////                .cacheDefaults(config).build();
//
//        //初始化一个RedisCacheWriter
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
//        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, config);
//
//        return cacheManager;
//    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {

        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1))
                .serializeKeysWith(
                        RedisSerializationContext
                                .SerializationPair
                                .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(
                        RedisSerializationContext
                                .SerializationPair
                                .fromSerializer(getJackson2JsonRedisSerializer()));
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
            logger.error("获取redis缓存异常,redis.key:{},cacheName:{},异常原因:{}",
                    o, cache.getName(), ExceptionUtils.getStackTrace(e));
            return;
        }

        @Override
        public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
            logger.error("获取redis缓存异常,redis.key:{},cacheName:{},异常原因:{}", o, cache.getName(),
                    ExceptionUtils.getStackTrace(e));
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
}


