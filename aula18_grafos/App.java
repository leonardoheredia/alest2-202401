package aula18_grafos;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Grafo g = new Grafo(4);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,3);
        g.adicionarAresta(2,3 );
        System.out.println(g.toDot());
        System.out.println(g.grau(0));
        System.out.println("Adjacentes do 0");
        System.out.println(g.adjacentes(0));

        ArrayList<Integer> caminho = g.caminharProfundidade(2);
        System.out.println(caminho);
    }
}
