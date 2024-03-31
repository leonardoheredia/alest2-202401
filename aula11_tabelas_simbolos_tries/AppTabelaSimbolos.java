package aula11_tabelas_simbolos_tries;

public class AppTabelaSimbolos {
    public static void main(String[] args) {
        TabelaSimbolos ts = new TabelaSimbolos<Integer, String>();
        ts.atualizar(455, "arroz");
        ts.atualizar(857, "feijao");
        System.out.println(ts);
        ts.atualizar(455, "arroz branco");
        System.out.println(ts);
    }
}
