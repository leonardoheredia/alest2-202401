package aula23_grafos_ordenacaotopologica;

public class AppOrdenacaoTopologica {
    public static void main(String[] args) {
        /*
        Digrafo dg = new Digrafo(6);
        dg.adicionarAresta(2, 3);
        dg.adicionarAresta(3, 1);
        dg.adicionarAresta(4, 0);
        dg.adicionarAresta(4, 1);
        dg.adicionarAresta(5, 2);
        dg.adicionarAresta(5,0);
        System.out.println(dg.toDot());

        OrdenacaoTopologica ordemTopologica = new OrdenacaoTopologica(dg);
        System.out.println("Ordem topologica = " + ordemTopologica);

         */

        Digrafo dg = new Digrafo(7);
        dg.adicionarAresta(0,1);
        dg.adicionarAresta(0,2);
        dg.adicionarAresta(0,5);
        dg.adicionarAresta(1,4);
        dg.adicionarAresta(3,2);
        dg.adicionarAresta(3,4);
        dg.adicionarAresta(3,5);
        dg.adicionarAresta(3,6);
        dg.adicionarAresta(5,2);
        dg.adicionarAresta(6,0);
        System.out.println(dg.toDot());

        OrdenacaoTopologica ordemTopologica = new OrdenacaoTopologica(dg);
        System.out.println(ordemTopologica);
        //[3 6 0 5 2 1 4]
    }
}
