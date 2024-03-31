package aula10_tabelas_hash_exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App2 {
    public static void main(String[] args) throws IOException {
        String arquivo = "aula10_tabelas_hash_exercicios\\chave_valor_1000_produtos_portugues_ajustado.txt";

        TabelaHashEncadeamentoSeparado hash = new TabelaHashEncadeamentoSeparado();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha = br.readLine();
        while(linha!=null) {
            long chave = Long.parseLong(linha.split(";")[0]);
            String valor = linha.split(";")[1];
            hash.adicionar(chave, valor);
            linha = br.readLine();
        }
        System.out.println("Capacidade = " + hash.getCAPACIDADE_INICIAL());
        System.out.println(hash.getColisoesAtual() + " colisoes ");


    }
}
