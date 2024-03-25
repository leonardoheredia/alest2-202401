package aula08_tabelas_hash;
public class App {
    public static void main(String[] args) {
        TabelaHashEndAberto tabelaHash = new TabelaHashEndAberto();
        tabelaHash.adicionar(250, "mariana");
        tabelaHash.adicionar(391, "leonardo");
        tabelaHash.adicionar(325, "tales");
        tabelaHash.adicionar(491,"francisco");
        tabelaHash.adicionar(156,"alexandre");
        tabelaHash.adicionar(820, "rafalea");


        System.out.println(tabelaHash);
    }
}
