package projetodog.com.edu.projetodog.Other;

/**
 * Created by edu-f on 14/07/2017.
 */

public class Dog {
   private String nome, raca, idade, temperamento;

    public Dog(String nome, String raca, String idade, String temperamento) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.temperamento = temperamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }
}
