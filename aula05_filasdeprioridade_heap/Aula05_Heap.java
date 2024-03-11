package aula05_filasdeprioridade_heap;

import utils.ArrayUtils;

import java.util.Scanner;

public class Aula05_Heap {
    public static void main(String[] args) {
        TestarHeap();
        //exemplo1();
        //exemplo2();
        //exemplo3();
        //exemplo4();
        //exemploheapsort();
        //gerarHeap();
    }
    public static void gerarHeap() {
        int[] a = {15, 23, 14, 30, 12, 18};
        ArrayUtils.imprimir(a);
        HeapMaximo hm = new HeapMaximo(a);
        ArrayUtils.imprimir(a);


    }
    public static void TestarHeap() {
        Scanner teclado = new Scanner(System.in);
        HeapMaximo h1 = new HeapMaximo(5);

        String schave;
        int chave;
        System.out.println("Digite os valores a serem inseridos ('s' para encerrar ou 'r' para remover o maximo)");
        do {
            schave=teclado.nextLine();
            if(schave.equals("r")) {
                h1.removerMaximo();
            }
            else if(schave.matches("[0-9]+")){
                chave = Integer.parseInt(schave);
                h1.inserir(chave);
            }
            ArrayUtils.imprimir(h1.getChaves());
            System.out.println("");
        }while(!schave.equals("s"));

    }
    public static void exemplo1() {


        HeapMaximo h1 = new HeapMaximo(10);

        ArrayUtils.imprimir(h1.getChaves());

        h1.inserir(10);
        h1.inserir(20);
        h1.inserir(15);
        h1.inserir(5);
        h1.inserir(30);
        h1.inserir(120);

        System.out.println();
        ArrayUtils.imprimir(h1.getChaves());

        h1.removerMaximo();
        ArrayUtils.imprimir(h1.getChaves());
        h1.removerMaximo();
        ArrayUtils.imprimir(h1.getChaves());

    }
    public static void exemplo2() {
        //gerando um heap-max a partir de um array, ou seja, convertendo o array em um heap

        int[] meuArray = {5, 20, 35, 12, 77, 90, 15, 100};
        ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        ArrayUtils.imprimir(meuHeap.getChaves());
        ArrayUtils.imprimir(meuHeap.getChaves());

    }
    public static void exemplo3() {
        //gerando um heap-max a partir de um array, ou seja, convertendo o array em um heap

        int[] meuArray = {0, 40, 87, 20, 90, 10, 99, 30, 20, 60, 10, 10, 15, 12, 10, 18, 13, 20, 13, 14, 18};
        //ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        //ArrayUtils.imprimir(meuHeap.getChaves());

        ArrayUtils.imprimirArvoreBinaria(meuHeap.getChaves());

    }
    public static void exemplo4() {
        //gerando um heap-max a partir de um array, ou seja, convertendo o array em um heap

        int[] meuArray = {0, 15, 23, 30, 11, 50, 33};
        ArrayUtils.imprimir(meuArray);
        HeapMaximo meuHeap = new HeapMaximo(meuArray);
        ArrayUtils.imprimir(meuHeap.getChaves());

    }

}