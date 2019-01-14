package listas.filas;

import redis.clients.jedis.Jedis;

import java.util.List;


public class FilaUtil {
    Jedis jedis;
    public FilaUtil(Jedis jedis) {
        this.jedis = jedis;
    }

    public void limpaFila(String fila){
        this.jedis.del(fila);
    }
    public void adicionarNaFila(String fila, String filme){
        this.jedis.rpush(fila,filme);
    }
    public void assistirFilme( String fila){
        String lpop = this.jedis.lpop(fila);
        System.out.println("Filme assistido " + lpop);
    }
    public void mostraFilaDoUsuario(String usuario){
        List<String> filmes = jedis.lrange(usuario, 0, 10);
        System.out.println("Fila do usuario " + usuario);
        filmes.forEach(System.out::println);
    }
    public void removerFilme(String usuario,String filme){
        jedis.lrem(usuario,0,filme);
    }
    public void tamanhoDaPlaylistDoUsuario(String usuario){
        jedis.llen(usuario);
    }

}
