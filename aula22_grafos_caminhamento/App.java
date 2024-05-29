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

        System.out.println("BUSCA EM PROFUNDIDADE ");
        System.out.println("-----------------------");
        BuscaEmProfundidade dfs0 = new BuscaEmProfundidade(g, 0);
        System.out.println(dfs0);

        System.out.println("Caminho do 0 ate o 0: " + dfs0.caminhoPara(0));
        System.out.println("Caminho do 0 ate o 1: " + dfs0.caminhoPara(1));
        System.out.println("Caminho do 0 ate o 2: " + dfs0.caminhoPara(2));
        System.out.println("Caminho do 0 ate o 3: " + dfs0.caminhoPara(3));
        System.out.println("Caminho do 0 ate o 4: " + dfs0.caminhoPara(4));

        BuscaEmProfundidade dfs4 = new BuscaEmProfundidade(g, 4);
        System.out.println(dfs4);

        System.out.println("Caminho do 4 ate o 0: " + dfs4.caminhoPara(0));
        System.out.println("Caminho do 4 ate o 1: " + dfs4.caminhoPara(1));
        System.out.println("Caminho do 4 ate o 2: " + dfs4.caminhoPara(2));
        System.out.println("Caminho do 4 ate o 3: " + dfs4.caminhoPara(3));
        System.out.println("Caminho do 4 ate o 4: " + dfs4.caminhoPara(4));


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("BUSCA EM LARGURA ");
        System.out.println("-----------------------");

        BuscaEmLargura bfs0 = new BuscaEmLargura(g, 0);
        System.out.println(bfs0);
        System.out.println("Caminho do 0 ate o 0: " + bfs0.caminhoPara(0));
        System.out.println("Caminho do 0 ate o 1: " + bfs0.caminhoPara(1));
        System.out.println("Caminho do 0 ate o 2: " + bfs0.caminhoPara(2));
        System.out.println("Caminho do 0 ate o 3: " + bfs0.caminhoPara(3));
        System.out.println("Caminho do 0 ate o 4: " + bfs0.caminhoPara(4));


    }
}
