package listas.filas;

import redis.clients.jedis.Jedis;

import java.util.List;

public class FilaDeProcessamento {
    public static final String USER_100 = "user_100";
    public static final String USER_101 = "user_101";

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100");
        FilaUtil filaUtil = new FilaUtil(jedis);
        filaUtil.limpaFila(USER_100);
        filaUtil.mostraFilaDoUsuario(USER_100);
        filaUtil.adicionarNaFila(USER_100,"LOTR");
        filaUtil.adicionarNaFila(USER_100,"The Hobbit");
        filaUtil.adicionarNaFila(USER_100,"Matrix");
        filaUtil.adicionarNaFila(USER_100,"The Hobbit");

        filaUtil.mostraFilaDoUsuario(USER_100);
       // filaUtil.assistirFilme(USER_100);
       // filaUtil.assistirFilme(USER_100);
        filaUtil.removerFilme(USER_100,"The Hobbit");
        filaUtil.mostraFilaDoUsuario(USER_100);

    }



}
