package aula26_grafos_dijkstra;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AppDijkstra {
    public static void main(String[] args) {
        HashMap<String, Integer> v = new LinkedHashMap<>();
        v.put("A", 0);
        v.put("B", 1);
        v.put("C", 2);
        v.put("D", 3);
        v.put("E", 4);
        GrafoValorado ex2 = new GrafoValorado(5);
        ex2.adicionarAresta(v.get("A"), v.get("B"), 4);
        ex2.adicionarAresta(v.get("A"), v.get("C"), 2);
        ex2.adicionarAresta(v.get("B"), v.get("C"), 1);
        ex2.adicionarAresta(v.get("B"), v.get("D"), 5);
        ex2.adicionarAresta(v.get("C"), v.get("D"), 8);
        ex2.adicionarAresta(v.get("C"), v.get("E"), 10);
        ex2.adicionarAresta(v.get("D"), v.get("E"), 2);

        System.out.println(ex2.toDot());

        System.out.println("Dijkstra");
        System.out.println("Origem 0");
        Dijkstra dijkstra = new Dijkstra(ex2, 0);
        System.out.println(dijkstra);


    }
}
