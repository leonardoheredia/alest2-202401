package aula22_grafos_caminhamento;

public class App {
    public static void main(String[] args) {
        GrafoListaAdjacencia g = new GrafoListaAdjacencia(5);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(1,4);
        System.out.println(g.toDot());
        System.out.println();

        BuscaEmProfundidade dfs = new BuscaEmProfundidade(g, 0);
        System.out.println(dfs);
        System.out.println(dfs.caminhoPara(3));

        BuscaEmLargura bfs = new BuscaEmLargura(g, 0);
        System.out.println(bfs);
        System.out.println(bfs.caminhoPara(3));

    }
}
