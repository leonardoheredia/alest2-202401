package aula20_grafos_revisao;

public class App {
    public static void main(String[] args) {
        GrafoMatrizAdjacencia g = new GrafoMatrizAdjacencia(5);

        g.adicionarAresta(0,1);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,2);
        g.adicionarAresta(2,3);
        g.adicionarAresta(2,4);
        g.adicionarAresta(3,4);


        System.out.println(g.printaMatriz());
        System.out.println(g.toDot());
        System.out.println(g.pegarAdjacentes(2));

        g.buscarEmProfundidade(4);
    }
}
