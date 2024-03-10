package aula04_analise_algoritmos_ordenacao;

import aula03_analise_algoritmos_ordenacao.BubbleSort;
import aula03_analise_algoritmos_ordenacao.InsertionSort;
import aula03_analise_algoritmos_ordenacao.MergeSort;
import aula03_analise_algoritmos_ordenacao.QuickSort;
import utils.ArrayUtils;

import java.util.Random;

public class AnaliseAlgoritmos2 {
    // Método para embaralhar o array
    private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void main(String[] args) {

        int[] meuArray;
        int[] meuArrayMerge;
        int[] meuArrayQuick;
        System.out.println("n;merge;quick");
        for (int n = 10; n < 100; n++) {
            meuArray = new int[n];
            meuArrayMerge = new int[n];
            meuArrayQuick = new int[n];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 500, true);
            ArrayUtils.clonarArray(meuArray, meuArrayMerge);
            ArrayUtils.clonarArray(meuArray, meuArrayQuick);

            MergeSort ms = new MergeSort();
            QuickSort qs = new QuickSort();

            ms.ordenar(meuArrayMerge);
            ArrayUtils.clonarArray(meuArrayMerge, meuArrayQuick);
            //shuffleArray(meuArrayQuick);

            qs.ordenar(meuArrayQuick);
            System.out.println(n
                    + ";" + ms.getOperacoes()
                    + ";" + qs.getOperacoes()
            );
            /*System.out.println(n + ";" +  bs.getOperacoes()
                                 + ";" + is.getOperacoes()
                                 + ";" + ms.getOperacoes()
                                 + ";" + qs.getOperacoes()
            );

             */
        }

    }















/*
    int TAMANHO_MAXIMO = 10_000;
    int[] aBubble;

        System.out.println("Gerar um array de N com números aleatorios");
        System.out.println("Ordenar esse array");
        System.out.println("Coletar o número de operações e o tempo");
        System.out.println("Analisar");

    aBubble = new int[TAMANHO_MAXIMO];
        ArrayUtils.preencherArrayComValoresInteirosAleatorios(aBubble, 1000, true);

    BubbleSort bs = new BubbleSort();
        bs.ordenar(aBubble);

        System.out.println(bs.getOperacoes() + " - " + bs.getTempoExecucao());

 */
}
