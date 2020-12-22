package vip.coolcode.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stringredis")
public class RedisStringController {

    //SpringBoot 提供的默认的操作接口,适合key-value都是字符串的情况
    @Autowired
    StringRedisTemplate redisClient;

    @RequestMapping("/testenv")
    public String testEnv() {
        //下面的操作相当于在Redis中: set testenv "my redis env"
        redisClient.opsForValue().set("testenv", "my redis env");
        String str = redisClient.opsForValue().get("testenv");
        //redisClient.opsForList().leftPush()
        //redisClient.opsForList().rightPush()
        //redisClient.opsForHash();
        //redisClient.opsForSet();

        //绑定key
        //BoundListOperations operations = redisClient.boundListOps("");

        return str;
    }


}
