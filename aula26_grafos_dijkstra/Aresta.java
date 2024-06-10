package aula26_grafos_dijkstra;

public class Aresta {
    private int v;
    private int w;
    private int peso;
    public Aresta(int v, int w, int peso) {
        this.v = v;
        this.w = w;
        this.peso = peso;
    }
    public int getW() {
        return w;
    }
    public int getPeso() {
        return peso;
    }
    public int getV() {
        return v;
    }
    public int getOutro(int vertice) {
        if(vertice==v) return w;
        else return v;
    }
}
