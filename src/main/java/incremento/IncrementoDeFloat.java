package incremento;

import redis.clients.jedis.Jedis;

public class IncrementoDeFloat {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        jedis.set("temperatura_marte","2.1");
    }
}
