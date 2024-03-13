package aula05_filasdeprioridade_heap;

import utils.ArrayUtils;

public class HeapComplexidade {
    public static void main(String[] args) {
        int[] a = new int[5];
        ArrayUtils.preencherArrayComValoresInteirosAleatorios(a, 100, false);
        System.out.println("Array original");
        ArrayUtils.imprimir(a);
        System.out.println("--------------");

        HeapMaximo heap = new HeapMaximo(a);

        System.out.println("Heap maximo");
        ArrayUtils.imprimir(a);
        System.out.println("--------------");
    }

}

