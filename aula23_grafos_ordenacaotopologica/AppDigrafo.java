package aula23_grafos_ordenacaotopologica;

public class AppDigrafo {
    public static void main(String[] args) {
        Digrafo dg = new Digrafo(4);
        dg.adicionarAresta(0, 3);
        dg.adicionarAresta(0, 2);
        dg.adicionarAresta(2, 3);
        dg.adicionarAresta(1, 3);
        System.out.println(dg.toDot());

    }
}
