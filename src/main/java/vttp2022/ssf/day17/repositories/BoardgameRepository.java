package vttp2022.ssf.day17.repositories;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class BoardgameRepository {

    @Value("${boardgame.cache.duration}")
    private Long cacheTime;
    
    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void save(String id, String payload) {
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        valueOp.set(id, payload, Duration.ofMinutes(cacheTime)); // cache expires after a certain time
    }

    public Optional<String> get(String id) {
        ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
        String value = valueOp.get(id);
        if (null == value) 
            return Optional.empty(); // empty box
        return Optional.of(value); // box with data
    }
}