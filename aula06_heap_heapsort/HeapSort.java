package aula06_heap_heapsort;

import utils.ArrayUtils;

public class HeapSort {
    public static void ordenar(int[] array) {
        HeapMaximo h = new HeapMaximo(array);
        for (int i = 0; i < array.length; i++) {
            int n = h.extrairMaximo();
        }
    }

    public static void main(String[] args) {
        int[] a = {90, 50, 13, 25, 60, 18};
        HeapSort.ordenar(a);
        ArrayUtils.imprimir(a);

    }
}
