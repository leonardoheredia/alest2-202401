package aula03_analise_algoritmos_ordenacao;

import utils.ArrayUtils;

public class AnaliseAlgoritmos {
    public static void main(String[] args) {

        int[] meuArray;
        int[] meuArrayBubble;
        int[] meuArrayInsertion;
        int[] meuArrayMerge;
        int[] meuArrayQuick;
        System.out.println("n;merge;quick");
        for (int n = 10; n < 1_500_000; n+=10_000) {
            meuArray = new int[n];
            meuArrayBubble = new int[n];
            meuArrayInsertion = new int[n];
            meuArrayMerge = new int[n];
            meuArrayQuick = new int[n];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 1_000_000, true);
            ArrayUtils.clonarArray(meuArray, meuArrayBubble);
            ArrayUtils.clonarArray(meuArray, meuArrayInsertion);
            ArrayUtils.clonarArray(meuArray, meuArrayMerge);
            ArrayUtils.clonarArray(meuArray, meuArrayQuick);

            BubbleSort bs = new BubbleSort();
            InsertionSort is = new InsertionSort();
            MergeSort ms = new MergeSort();
            QuickSort qs = new QuickSort();

            //bs.ordenar(meuArrayBubble);
            //is.ordenar(meuArrayInsertion);
            ms.ordenar(meuArrayMerge);
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
