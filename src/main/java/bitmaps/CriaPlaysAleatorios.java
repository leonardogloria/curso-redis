package bitmaps;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class CriaPlaysAleatorios {
    public static final int QTD_USUARIOS = 100;
    public static final int QTD_PLAYS = 600;
    public static final int QTD_DIAS = 10;

    public void criaChaves(long usuario, String dia){
        Jedis jedis = new Jedis("192.168.99.100");
        String key = String.format("play:%s",dia);
        jedis.setbit(key,usuario,true);

    }

    public static void main(String[] args) {
        CriaPlaysAleatorios criaPlaysAleatorios = new CriaPlaysAleatorios();
        for(int play = 1;play<= QTD_PLAYS;play++){
            long usuario = new Random().nextInt(QTD_USUARIOS) + 1;
            String dia = String.format("%02d/08/2018" , (new Random().nextInt(QTD_DIAS) + 1));
            criaPlaysAleatorios.criaChaves(usuario,dia);

        }
    }


}
