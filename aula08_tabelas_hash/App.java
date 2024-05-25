package aula08_tabelas_hash;
public class App {
    public static void main(String[] args) {
        TabelaHashEndAberto tabelaHash = new TabelaHashEndAberto();
        tabelaHash.adicionar(17, "mariana");
        tabelaHash.adicionar(19, "leonardo");
        tabelaHash.adicionar(18, "tales");
        tabelaHash.adicionar(27,"francisco");
        tabelaHash.adicionar(21, "joao");
        System.out.println(tabelaHash);

        String teste = "isso eh um teste";
        empilhar(teste);
    }
    public static void empilhar(String palavra) {
        char[] charArray = palavra.toCharArray();
        for (char c:charArray) {
            System.out.println(c);
        }
        for (int i = 0; i < palavra.length(); i++) {
            System.out.println(palavra.charAt(i));
        }
    }
}
