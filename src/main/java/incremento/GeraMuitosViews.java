package incremento;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;

public class GeraMuitosViews {
    public static final String VENON = "venon";
    public static final String GLASS = "glass";
    public static final String MARTIAN = "martian";
    public static final String SPIDER_MAN = "spider_man";


    public static final int QTD_VIEWS = 1000000;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        jedis.mset(VENON,"0",GLASS,"0",MARTIAN,"0",SPIDER_MAN,"0");
        for(int i = 1; i< QTD_VIEWS; i++){
            int movie = new Random().nextInt(4) + 1;
            switch (movie){
                case 1:
                    jedis.incr(VENON);
                    break;
                case 2:
                    jedis.incr(GLASS);
                    break;
                case 3:
                    jedis.incr(MARTIAN);
                    break;
                case 4:
                    jedis.incr(SPIDER_MAN);
                    break;

            }

        }
        List<String> filmes = jedis.mget(VENON, GLASS, MARTIAN, SPIDER_MAN);
        filmes.forEach(System.out :: println);
    }
}
