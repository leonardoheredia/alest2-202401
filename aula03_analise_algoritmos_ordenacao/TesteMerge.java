import java.util.Random;

public class TesteMerge {
    public static void main(String[] args) {
        int repetitions = 100;
        int startSize = 100;
        int endSize = 10000;

        System.out.println("Número de repetições: " + repetitions);
        System.out.println("Tamanho do array\tNúmero de operações");

        for (int size = startSize; size <= endSize; size++) {
            long totalOperations = 0;

            for (int i = 0; i < repetitions; i++) {
                int[] array = generateRandomArray(size);
                totalOperations += mergeSortCount(array);
            }

            long averageOperations = totalOperations / repetitions;
            System.out.println(size + "\t\t\t" + averageOperations);
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int j = 0; j < size; j++) {
            array[j] = random.nextInt(10000); // Alterado para 10000 para aumentar o intervalo
        }
        return array;
    }

    public static long mergeSortCount(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int meio = array.length / 2;
        int[] metadeEsquerda = new int[meio];
        int[] metadeDireita = new int[array.length - meio];

        System.arraycopy(array, 0, metadeEsquerda, 0, meio);
        System.arraycopy(array, meio, metadeDireita, 0, array.length - meio);

        long operacoesEsquerda = mergeSortCount(metadeEsquerda);
        long operacoesDireita = mergeSortCount(metadeDireita);

        long operacoesMerge = mergeCount(array, metadeEsquerda, metadeDireita);

        return operacoesEsquerda + operacoesDireita + operacoesMerge;
    }

    public static long mergeCount(int[] array, int[] metadeEsquerda, int[] metadeDireita) {
        int i = 0;
        int j = 0;
        int k = 0;
        long operacoes = 0;

        while (i < metadeEsquerda.length && j < metadeDireita.length) {
            if (metadeEsquerda[i] < metadeDireita[j]) {
                array[k++] = metadeEsquerda[i++];
            } else {
                array[k++] = metadeDireita[j++];
            }
            operacoes++;
        }

        while (i < metadeEsquerda.length) {
            array[k++] = metadeEsquerda[i++];
            operacoes++;
        }

        while (j < metadeDireita.length) {
            array[k++] = metadeDireita[j++];
            operacoes++;
        }

        return operacoes;
    }
}
