package cn.gorit.util;

import cn.gorit.config.AppConfig;
import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class RedisCacheUtil implements Cache {

    private String namespace; //存储namespace
    private RedisTemplate redisTemplate=(RedisTemplate) AppConfig.getBean("redisTemplate");

    private long timeout=300;

    //涉及并发操作缓存需要加锁
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock(); //读写锁

    public RedisCacheUtil(String namespace) {
        super();
        this.namespace = namespace;
    }

    @Override
    public String getId() {
        return namespace;
    }

    @Override
    public void putObject(Object key, Object value) {
        // TODO Auto-generated method stub
        System.out.println("将查询结果存储到cache.key:"+key+",value"+value);
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(key,value,timeout, TimeUnit.SECONDS);
    }

    @Override
    public Object getObject(Object key) {
        // TODO Auto-generated method stub
        System.out.println("从缓存中读取结果.key:"+key);
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    @Override
    public Object removeObject(Object key) {
        // TODO Auto-generated method stub
        System.out.println("从缓存中清除.key:"+key);
        ValueOperations operations = redisTemplate.opsForValue();
        Object value = operations.get(key);
        redisTemplate.delete(key);
        return value;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        System.out.println("从缓存区删除所有数据");
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushAll();
                return null;
            }
        });
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        //将读写锁返回
        return readWriteLock;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

}
