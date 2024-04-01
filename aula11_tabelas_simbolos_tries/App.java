package aula11_tabelas_simbolos_tries;


import java.util.Dictionary;

public class App {
    public static void main(String[] args) {
        TabelaSimbolosEncadeada<String, String> veiculos = new TabelaSimbolosEncadeada<>();

        veiculos.atualizar("IWR-2372", "Carro do Nicolas");
        veiculos.atualizar("IXX-9991", "Opala");
        System.out.println(veiculos);
        System.out.println(veiculos.buscar("IXX-9991"));

    }
}
