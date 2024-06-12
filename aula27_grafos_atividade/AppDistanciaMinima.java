package aula27_grafos_atividade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AppDistanciaMinima {
    public static void main(String[] args) throws FileNotFoundException {
        String localDoArquivo = "C:\\TEMP\\distancias_locais.csv";
        LinkedHashMap<String, Integer> verticesRotulados = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(localDoArquivo))) {
            String linha;
            linha = br.readLine(); //primeira linha
            int numVertices = Integer.parseInt(linha);
            System.out.println("Número de vértices: " + numVertices);
            int verticesCarregados = 0;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                System.out.println(valores[0] + " " + valores[1] + " " + valores[2]);
                if(!verticesRotulados.containsKey(valores[0])) {
                    verticesRotulados.put(valores[0], verticesCarregados);
                    verticesCarregados++;
                }
                if(!verticesRotulados.containsKey(valores[1])) {
                    verticesRotulados.put(valores[1], verticesCarregados);
                    verticesCarregados++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + localDoArquivo);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Vertices rotulados:");
        for (String key : verticesRotulados.keySet()) {
            System.out.println(verticesRotulados.get(key) + " - " + key);
        }

        System.out.println();
        System.out.println("Menor caminho saindo de Casa para todos os outros locais");
        //IMPLEMENTAR AQUI
    }
}
