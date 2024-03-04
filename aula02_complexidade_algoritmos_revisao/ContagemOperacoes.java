package aula02_complexidade_algoritmos_revisao;
public class ContagemOperacoes {

    public static void main(String[] args) {
        int LIMITE = 100;
        System.out.println("n;funcao_05");
        for (int n = 1; n <=LIMITE ; n++) {
            System.out.println(n + ";" + funcao_03(n));
        }
    }
    public static int funcao_03(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < 2 * i; j++)
                operacoes++;
        return operacoes;
    }

    public static int funcao_01(int n) {
        int operacoes = 10;
        return operacoes;
    }
    public static int funcao_02(int n) {
        int operacoes = n + 30;
        return operacoes;
    }

    public static int funcao_05(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < i + 2; j++)
                for (int k = 0; k < n; k++)
                    operacoes++;
        return operacoes;
    }


}
