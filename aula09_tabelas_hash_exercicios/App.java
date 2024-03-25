package aula09_tabelas_hash_exercicios;

public class App {
    public static void main(String[] args) {
        TabelaHashEncadeamentoSeparado tabelaHash = new TabelaHashEncadeamentoSeparado();
        tabelaHash.adicionar(500, "leite em po");
        tabelaHash.adicionar(857, "refrigerante");
        tabelaHash.adicionar(334, "sabao em barra");
        tabelaHash.adicionar(825, "suco de laranja");
        tabelaHash.adicionar(101, "shampoo");
        System.out.println(tabelaHash);

        System.out.println(tabelaHash.buscar(857)); //tem que retornar "refrigerante"

        tabelaHash.atualizar(500, "iogurte"); //tem que trocar o valor de leite em po para iogurte
        System.out.println(tabelaHash);
    }
}
