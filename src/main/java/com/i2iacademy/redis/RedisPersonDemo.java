package com.i2iacademy.redis;

import redis.clients.jedis.Jedis;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisPersonDemo {
    private static final String REDIS_HOST ="localhost";
    private static final int REDIS_PORT =6379;
    private static final int TOTAL_RECORDS = 10000;

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
            System.out.println("Connected to Redis: " + jedis.ping());
            for (int i=1; i<=TOTAL_RECORDS; i++){
                Person person = new Person(i, "Person-" + i, 20 + (i%50));
                String key ="person:" + i;
                String json =objectMapper.writeValueAsString(person);
                jedis.set(key, json);
            }
            System.out.println(TOTAL_RECORDS + " records inserted into Redis.");
            System.out.println("Verifying first 5 records: ");
            for (int i = 1; i<= 5; i++){
                String key = "person:" + i;
                String json = jedis.get(key);
                Person person = objectMapper.readValue(json, Person.class);
                System.out.println(" " + person);
            }
        }
    }
}
