package aula13_estruturas_dados_espaciais;

import java.util.LinkedList;
import java.util.Queue;

public class QuadtreePontos {

    private class Nodo {
        public Ponto ponto;
        public Nodo NE;
        public Nodo SE;
        public Nodo NO;
        public Nodo SO;
        public Nodo pai;
        public Nodo(String rotulo, int x, int y) {
            this.ponto = new Ponto(rotulo, x,y);
        }
        @Override
        public String toString() {
            String str = ponto.rotulo + " = ";
            str+="{";
            if(this.NO==null) str += " NO ";
            else str += " " + NO.ponto.rotulo + " ";
            str+=",";
            if(this.SO==null) str += " SO ";
            else str += " " + SO.ponto.rotulo + " ";
            str+=",";
            if(this.SE==null) str += " SE ";
            else str += " " + SE.ponto.rotulo + " ";
            str+=",";
            if(this.NE==null) str += " NE ";
            else str += " " + NE.ponto.rotulo + " ";
            str+="}";
            return str;
        }
    }
    private Nodo raiz;
    private int minimoX = 0;
    private int minimoY = 0;
    private int maximoX = 100;
    private int maximoY = 100;
    public QuadtreePontos() {

    }
    public void adicionar(String rotulo, int x, int y) {
        Nodo novoNodo = new Nodo(rotulo, x, y);
        if(this.raiz==null) {
            raiz = novoNodo;
        }
        else {
            Nodo explorador = raiz;
            while (explorador!=null) {
                if (novoNodo.ponto.x < explorador.ponto.x && novoNodo.ponto.y >= explorador.ponto.y){
                    if(explorador.NO == null)  {
                        explorador.NO = novoNodo;
                        explorador = null;
                    }
                    else explorador = explorador.NO;
                }
                else if(novoNodo.ponto.x < explorador.ponto.x && novoNodo.ponto.y < explorador.ponto.y) {
                    if(explorador.SO == null)  {
                        explorador.SO = novoNodo;
                        explorador = null;
                    }
                    else explorador = explorador.SO;
                }
                else if (novoNodo.ponto.x >= explorador.ponto.x && novoNodo.ponto.y >= explorador.ponto.y) {
                    if(explorador.NE == null)  {
                        explorador.NE = novoNodo;
                        explorador = null;
                    }
                    else explorador = explorador.NE;
                }
                else if (novoNodo.ponto.x >= explorador.ponto.x && novoNodo.ponto.y < explorador.ponto.y)  {
                    if(explorador.SE == null)  {
                        explorador.SE = novoNodo;
                        explorador = null;
                    }
                    else explorador = explorador.SE;
                }
            }
        }
    }

    /*Recebe uma coordenada x e y e retorna se a mesma existe na quadtree*/

    public boolean existe(int x, int y) {
        //(30, 35)
        Nodo navegador = this.raiz;
        while(navegador!=null) {
            //testa se o ponto existe
            if(x == navegador.ponto.x && y == navegador.ponto.y) return true;
            //verifica NO
            if(x<navegador.ponto.x && y>=navegador.ponto.y) navegador = navegador.NO;
                //verifica SO
            else if (x<navegador.ponto.x && y<navegador.ponto.y) navegador = navegador.SO;
                //verifica SE
            else if (x>=navegador.ponto.x && y<navegador.ponto.y) navegador =navegador.SE;
                //verifica NE
            else if (x>=navegador.ponto.x && y>=navegador.ponto.y) navegador = navegador.NE;
        }
        return false;
    }
    public String imprimirQuadtree() {
        StringBuilder sb = new StringBuilder();
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(raiz);
        sb.append(raiz + System.lineSeparator());
        while(!fila.isEmpty()) {
            Nodo n = fila.poll();
            if(n.NO!=null) {
                fila.add(n.NO);
                sb.append(n.NO + System.lineSeparator());
            }
            if(n.SO!=null) {
                fila.add(n.SO);
                sb.append(n.SO+ System.lineSeparator());
            }
            if(n.SE!=null) {
                fila.add(n.SE);
                sb.append(n.SE+ System.lineSeparator());
            }
            if(n.NE!=null) {
                fila.add(n.NE);
                sb.append(n.NE + System.lineSeparator());
            }
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return this.imprimirQuadtree();
    }

    public static void main(String[] args) {
        QuadtreePontos q = new QuadtreePontos();
        q.adicionar("A", 10,10);
        q.adicionar("B", 70,60);
        q.adicionar("C", 5, 90);
        q.adicionar("D", 80,40);

        System.out.println(q);

        System.out.println(q.existe(30,35));
        System.out.println(q.existe(70,60));
    }


}