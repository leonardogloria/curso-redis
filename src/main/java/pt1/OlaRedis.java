package pt1;

import redis.clients.jedis.Jedis;

public class OlaRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        jedis.set("ola","redis");
        String ola = jedis.get("ola");
        System.out.println(ola);
    }
}
