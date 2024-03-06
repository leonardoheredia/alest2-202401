package aula04_analise_algoritmos_ordenacao;

import aula03_analise_algoritmos_ordenacao.BubbleSort;
import aula03_analise_algoritmos_ordenacao.InsertionSort;
import aula03_analise_algoritmos_ordenacao.MergeSort;
import aula03_analise_algoritmos_ordenacao.QuickSort;
import utils.ArrayUtils;

public class AnaliseBubble {
    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60};
        inverteArray(a);
        ArrayUtils.imprimir(a);
        //System.exit(0);

        int[] meuArray;
        int[] meuArrayBubble;
        System.out.println("n;bubble");
        for (int n = 10; n < 1_000; n+=10) {
            meuArray = new int[n];
            meuArrayBubble = new int[n];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 1_000_000, true);

            MergeSort ms = new MergeSort();
            ms.ordenar(meuArray);
            inverteArray(meuArray);
            ArrayUtils.clonarArray(meuArray, meuArrayBubble);


            BubbleSort bs = new BubbleSort();

            bs.ordenar(meuArrayBubble);

            System.out.println(n + ";" +  bs.getOperacoes());


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
