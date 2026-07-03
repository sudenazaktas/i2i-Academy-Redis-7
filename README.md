# i2i-Academy-Redis-7

A simple Java application demonstrating how to use Redis as an in-memory data store. The project sets up Redis and RedisInsight via Docker, then uses a Java client called Jedis to insert and retrieve 10,000 dummy `Person` records.

## Technologies Used

* Java 17
* Maven
* Jedis
* Jackson
* Docker
* Redis
* RedisInsight

## What This Project Does

1. Connects to a local Redis instance running in a Docker container.
2. Creates 10,000 `Person` objects with id, name, and age fields.
3. Converts each object to JSON format using Jackson.
4. Stores each record in Redis under a key following the `person:{id}` pattern.
5. Retrieves and prints the first 5 records to verify that the data was stored correctly.

## How to Run

First, start the Redis and RedisInsight containers:

```bash
docker run -d --name redis-server -p 6379:6379 redis:latest
docker run -d --name redisinsight -p 5540:5540 redis/redisinsight:latest
```

Then, open the project in an IDE such as IntelliJ IDEA and run the `RedisPersonDemo.main()` method.

Optionally, open RedisInsight at:

```text
http://localhost:5540
```

## RedisInsight Note

Since RedisInsight runs in its own Docker container, it may not reach Redis by using `localhost`. In this case, `host.docker.internal:6379` can be used as the Redis connection address.

## Expected Result

After running the application, 10,000 `Person` records should be inserted into Redis. The application also prints the first 5 records to confirm that the data was stored and retrieved successfully.

RedisInsight can be used to visually check the stored keys in the Browser tab.
