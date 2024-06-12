package aula27_grafos_atividade;

public class Aresta {
    private int v;
    private int w;
    private double peso;
    public Aresta(int v, int w, double peso) {
        this.v = v;
        this.w = w;
        this.peso = peso;
    }
    public int getW() {
        return w;
    }
    public double getPeso() {
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
