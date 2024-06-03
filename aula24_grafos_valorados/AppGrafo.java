package aula24_grafos_valorados;

public class AppGrafo {
    public static void main(String[] args) {
        Grafo gv = new Grafo(4);
        gv.adicionarAresta(0, 1, 200);
        gv.adicionarAresta(0, 2, 500);
        gv.adicionarAresta(1, 3, 544);
        gv.adicionarAresta(2, 3, 322);
        System.out.println(gv.toDot());

    }
}
