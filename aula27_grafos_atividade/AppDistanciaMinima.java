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

        GrafoValorado grafo = null;

        try (BufferedReader br = new BufferedReader(new FileReader(localDoArquivo))) {
            String linha;
            linha = br.readLine(); //primeira linha
            int numVertices = Integer.parseInt(linha);
            System.out.println("Número de vértices: " + numVertices);

            grafo = new GrafoValorado(numVertices);

            int verticesCarregados = 0;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if(!verticesRotulados.containsKey(valores[0])) {
                    verticesRotulados.put(valores[0], verticesCarregados);
                    verticesCarregados++;
                }
                if(!verticesRotulados.containsKey(valores[1])) {
                    verticesRotulados.put(valores[1], verticesCarregados);
                    verticesCarregados++;
                }

                int v = verticesRotulados.get(valores[0]);
                int w = verticesRotulados.get(valores[1]);
                double peso = Double.parseDouble(valores[2]);
                grafo.adicionarAresta(v, w, peso);

            }
            System.out.println(grafo.toDot());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + localDoArquivo);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }


        System.out.println(grafo.toDot());

        System.out.println();
        System.out.println("Menor caminho saindo de Casa para todos os outros locais");
        //IMPLEMENTAR AQUI
    }
}
