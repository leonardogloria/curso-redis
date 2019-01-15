package ApagandoChaves;

import redis.clients.jedis.Jedis;

public class ApagandoAsChaves {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        jedis.flushAll();
        jedis.flushDB();
    }
}
