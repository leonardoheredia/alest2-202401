package aula04_analise_algoritmos_ordenacao;

import aula03_analise_algoritmos_ordenacao.BubbleSort;
import aula03_analise_algoritmos_ordenacao.InsertionSort;
import aula03_analise_algoritmos_ordenacao.MergeSort;
import aula03_analise_algoritmos_ordenacao.QuickSort;
import utils.ArrayUtils;

public class AnaliseMergeQuick {
    public static void main(String[] args) {

        int[] meuArray;
        int[] meuArrayMerge;
        int[] meuArrayQuick;
        System.out.println("n;merge;quick");
        for (int n = 100; n < 10_000; n+=50) {
            meuArray = new int[n];
            meuArrayMerge = new int[n];
            meuArrayQuick = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 1_000_000, true);

            //ordenar o array para mandar ja ordenado
            MergeSort ms0 = new MergeSort();
            ms0.ordenar(meuArray);
            //inverteArray(meuArray);

            ArrayUtils.clonarArray(meuArray, meuArrayMerge);
            ArrayUtils.clonarArray(meuArray, meuArrayQuick);

            MergeSort ms = new MergeSort();
            QuickSort qs = new QuickSort();

            ms.ordenar(meuArrayMerge);
            qs.ordenar(meuArrayQuick);

            System.out.println(n
                                 + ";" + ms.getOperacoes()
                                 + ";" + qs.getOperacoes()
            );


        }

    }
    public static void inverteArray(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i -1];
            array[array.length - i - 1] = temp;
        }
    }

}
