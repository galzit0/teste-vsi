package api.testevsi.questao1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ProcessamentoDeTexto {

    public static List<String> processarTexto(String entrada) {
        if (entrada == null || entrada.isEmpty()) {
            throw new IllegalArgumentException("Não pode ser vazio.");
        }

        if (!entrada.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Deve conter apenas letras.");
        }

        List<String> resultado = new ArrayList<>();
        gerarAnagramas("", entrada, resultado);
        return resultado;
    }
    /**
     * Método recursivo para gerar anagramas.
     * Básicamente ele pega um char, guarda ele e reorganiza o resto em loop até utilizar todos os chars.
     * @param combinacaoAtual A parte da palavra já formada.
     * @param pendentes As letras que ainda estão pendnetes para serem utilizadas para formar os anagramas.
     * @param resultado A lista onde seram armazenados os anagramas.
     */
    private static void gerarAnagramas(String combinacaoAtual, String pendentes, List<String> resultado) {
        if (pendentes.isEmpty()) {
            resultado.add(combinacaoAtual);
        } else {
            IntStream.range(0, pendentes.length())
                    .forEach(i -> gerarAnagramas(
                            combinacaoAtual + pendentes.charAt(i),
                            pendentes.substring(0, i) + pendentes.substring(i + 1),
                            resultado));
        }
    }

    public static void main(String[] args) {
        List<String> anagramas = processarTexto("abc");
        System.out.println(String.join(", ", anagramas));
    }
}
