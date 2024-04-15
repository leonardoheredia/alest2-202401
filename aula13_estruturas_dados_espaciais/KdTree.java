package aula13_estruturas_dados_espaciais;

public class KdTree {

    private class Nodo {
        Ponto ponto;
        Nodo esquerda;
        Nodo direita;
        Ponto pai;
        public Nodo(String rotulo, int x, int y) {
            this.ponto = new Ponto(rotulo, x, y);
        }
        public Nodo(Ponto p) {
            this.ponto = p;
        }
    }

    private Nodo raiz;

    public void adicionar(String rotulo, int x, int y) {
        Nodo novoNodo = new Nodo(rotulo, x, y);
        if(raiz==null) {
            raiz = novoNodo;
        }
        else {
            Nodo explorador = raiz;
            int nivel = 0;
            while (explorador!=null) {
                if(nivel % 2 == 0) { //discriminador eh o x
                    if(novoNodo.ponto.x < explorador.ponto.x) {
                        if(explorador.esquerda==null) {
                            explorador.esquerda = novoNodo;
                            explorador = null;
                        }
                        else explorador = explorador.esquerda;
                    }
                    else {
                        if(explorador.direita==null) {
                            explorador.direita = novoNodo;
                            explorador = null;
                        }
                        else explorador = explorador.direita;
                    }
                }
                else {
                    if(novoNodo.ponto.y < explorador.ponto.y) {
                        if(explorador.esquerda==null) {
                            explorador.esquerda = novoNodo;
                            explorador = null;
                        }
                        else explorador = explorador.esquerda;
                    }
                    else {
                        if(explorador.direita==null) {
                            explorador.direita = novoNodo;
                            explorador = null;
                        }
                        else explorador = explorador.direita;
                    }
                }
                nivel++;
            }
        }
    }
    public boolean existe(int x, int y) {
        //IMPLEMENTAR
        return false;
    }

    public static void main(String[] args) {
        KdTree kd = new KdTree();
        kd.adicionar("A", 10,10);
        kd.adicionar("B", 15,10);
    }

}