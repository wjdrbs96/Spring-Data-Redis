package me.gyun.redis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @DisplayName("Redis로 String 테스트")
    @Test
    void stringTest() {
        final String key = "Gyunny";
        final ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();

        stringStringValueOperations.set(key, "1");
        assertThat(stringStringValueOperations.get(key)).isEqualTo("1");
    }

    @DisplayName("Redis로 List 테스트")
    @Test
    void listTest() {
        final String key = "Gyun";

        final ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(key , "a");
        listOperations.rightPush(key , "b");
        listOperations.rightPush(key , "c");
        listOperations.rightPush(key , "d");

        assertThat(listOperations.index(key, 1)).isEqualTo("b");
    }

    @DisplayName("Redis로 Set 테스트")
    @Test
    void setTest() {
        String key = "gyn";
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();

        setOperations.add(key, "a");
        setOperations.add(key, "b");
        setOperations.add(key, "c");
        setOperations.add(key, "c");

        assertThat(setOperations.size(key)).isEqualTo(3);
    }

    @DisplayName("Redis로 SortedSet 테스트")
    @Test
    void sortedSetTest() {
        String key = "set";
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();

        zSetOperations.add(key, "a", 1);
        zSetOperations.add(key, "b", 5);
        zSetOperations.add(key, "c", 10);
        zSetOperations.add(key, "c", 10);

        assertThat(zSetOperations.size(key)).isEqualTo(3);
    }

    @DisplayName("Redis로 Hash 테스트")
    @Test
    void hashTest() {
        String key = "hash";

        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(key, "Hello1", "Hi1");
        hashOperations.put(key, "Hello2", "Hi2");
        hashOperations.put(key, "Hello3", "Hi3");

        assertThat(hashOperations.get(key, "Hello1")).isEqualTo("Hi1");
        assertThat(hashOperations.size(key)).isEqualTo(3);
    }
}
