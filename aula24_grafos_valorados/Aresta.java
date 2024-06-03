package aula24_grafos_valorados;

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
}
