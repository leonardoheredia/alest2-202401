package aula10_tabelas_hash_exercicios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String arquivo = "aula10_tabelas_hash_exercicios//chave_valor_1000_produtos_portugues_ajustado.txt";
        TabelaHashEncadeamentoSeparado hash = new TabelaHashEncadeamentoSeparado();
        int chavesInseridas = 0;
        try {

            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null) {
                long chave = Long.parseLong(line.split(";")[0]);
                String valor = line.split(";")[1];
                hash.adicionar(chave, valor);
                chavesInseridas++;
                //System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("colisoes = " + hash.getColisoesAtual());
        System.out.println("para " + chavesInseridas + " inseridas");
    }
}
