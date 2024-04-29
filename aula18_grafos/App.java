package aula18_grafos;

public class App {
    public static void main(String[] args) {
        Grafo g = new Grafo(4);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        System.out.println(g.toDot());
    }
}
