package aula04_analise_algoritmos_ordenacao;

import aula03_analise_algoritmos_ordenacao.BubbleSort;
import utils.ArrayUtils;

public class TesteBubble {
    public static void main(String[] args) {
        //rodar o bubble 1000 vezes para um N tamanho 1000
        int N = 10;
        int LIMITE = 100;


        int operacoes = 0;
        for (int i = 0; i < LIMITE; i++) {
            int[] array = new int[N];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(array, 999, true);
            BubbleSort bs = new BubbleSort();
            bs.ordenar(array);
            System.out.println(bs.getOperacoes());
        }

    }
}
