package incremento;

import redis.clients.jedis.Jedis;

public class ComandoDeIncremento {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        jedis.set("VENON","2");
        jedis.incr("VENON");
        jedis.incr("VENON");
        jedis.incr("VENON");
        String venon = jedis.get("VENON");
        System.out.println(venon);

        jedis.set("Ant-man","0");
        jedis.incrBy("Ant-man", 2);
        jedis.incrBy("Ant-man", 7);

        String ant = jedis.get("Ant-man");
        System.out.println(ant);

        jedis.set("temperatura_marte","2");
        jedis.incrByFloat("temperatura_marte", 3.1);
        String temp = jedis.get("temperatura_marte");
        System.out.println(temp);

        jedis.set("tentativas_restantes","5");
        jedis.incrBy("tentativas_restantes", -1);
        jedis.incrBy("tentativas_restantes", -1);
        jedis.decr("tentativas_restantes");
        jedis.decrBy("tentativas_restantes",5);
        String tentativas = jedis.get("tentativas_restantes");
        System.out.println(tentativas);



    }
}
