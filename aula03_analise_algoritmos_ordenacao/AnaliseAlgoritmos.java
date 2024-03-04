package aula03_analise_algoritmos_ordenacao;

import utils.ArrayUtils;

public class AnaliseAlgoritmos {
    public static void main(String[] args) {
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
    }

}
