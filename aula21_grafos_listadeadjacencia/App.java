package aula21_grafos_listadeadjacencia;

public class App {
    public static void main(String[] args) {
        GrafoListaAdjacencia g = new GrafoListaAdjacencia(5);

        g.adicionarAresta(0,2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,2);
        g.adicionarAresta(1,3);
        g.adicionarAresta(1,4);


        System.out.println(g);
        System.out.println("");
        System.out.println(g.toDot());

        g.buscarEmProfundidade(0);
        g.buscarEmLargura(0);
    }
}
