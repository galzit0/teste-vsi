package api.testevsi.questao2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /**
     * Basicamente o equals compara os objetos, enquanto o hashCode gera um hash unico para cada objeto baseado nos
     * valores dos atributos.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Carlos", 30);
        Pessoa pessoa2 = new Pessoa("Carlos", 30);
        Pessoa pesssoa3 = new Pessoa("Ana", 25);

        System.out.println("p1.equals(p2): " + pessoa1.equals(pessoa2)); // true, nome e idade são iguais
        System.out.println("p1.equals(p3): " + pessoa1.equals(pesssoa3)); // false, os atributos são diferentes

        System.out.println("p1.hashCode() == p2.hashCode(): " + (pessoa1.hashCode() == pessoa2.hashCode())); // true, são considerados iguais pelo equals
        System.out.println("p1.hashCode() == p3.hashCode(): " + (pessoa1.hashCode() == pesssoa3.hashCode())); // false, atributos são diferentes.

        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pesssoa3);

        System.out.println("Tamanho do hash: " + pessoas.size()); // tem que ser 2, p1 e p2 são considerados iguais
    }
}
