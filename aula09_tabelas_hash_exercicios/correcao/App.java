package aula09_tabelas_hash_exercicios.correcao;

public class App {
    public static void main(String[] args) {
        TabelaHashEncadeamentoSeparado tabelaHash = new TabelaHashEncadeamentoSeparado();
        tabelaHash.adicionar(8, "p8");
        tabelaHash.adicionar(9, "p8");
        tabelaHash.adicionar(18, "p18");
        tabelaHash.adicionar(23, "23");
        tabelaHash.adicionar(35, "35");
        tabelaHash.adicionar(19, "19");
        System.out.println(tabelaHash);
        System.out.println(tabelaHash.buscar(9));
        System.out.println(tabelaHash.buscar(19));
        System.out.println("");
        tabelaHash.remover(8);
        System.out.println(tabelaHash);
        tabelaHash.remover(18);
        System.out.println(tabelaHash);
        tabelaHash.remover(18);
        System.out.println(tabelaHash);
        tabelaHash.atualizar(9, "novovalor");
        System.out.println(tabelaHash);


    }
}
