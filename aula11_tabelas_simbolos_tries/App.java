package aula11_tabelas_simbolos_tries;


public class App {
    public static void main(String[] args) {
        TabelaSimbolosEncadeada<String, String> veiculos = new TabelaSimbolosEncadeada<>();

        veiculos.atualizar("IWR-2372", "Carro do Nicolas");
        System.out.println(veiculos);
    }
}
