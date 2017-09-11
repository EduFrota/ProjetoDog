package projetodog.com.edu.projetodog.Other;

import java.io.Serializable;

/**
 * Created by edu-f on 14/07/2017.
 */

public class Dog implements Serializable {
   private String url,nome, idade,raca, cidade, estado, peso, comprimento,altura,cor1,cor2,
      temperamento1,getTemperamento2,temperamento3, pelo, filhotes_ninhada,data_cio,rg,nome_pai,nome_mãe;

   private int meu, genero, favorito, vacina;


    public Dog(String url, String nome, String idade, String raca, String cidade, String estado, String peso, String comprimento, String altura, String cor1, String cor2, String temperamento1, String getTemperamento2, String temperamento3, String pelo, String filhotes_ninhada, String data_cio, String rg,
               String nome_pai, String nome_mãe, int meu, int genero, int favorito, int vacina) {
        this.url = url;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.cidade = cidade;
        this.estado = estado;
        this.peso = peso;
        this.comprimento = comprimento;
        this.altura = altura;
        this.cor1 = cor1;
        this.cor2 = cor2;
        this.temperamento1 = temperamento1;
        this.getTemperamento2 = getTemperamento2;
        this.temperamento3 = temperamento3;
        this.pelo = pelo;
        this.filhotes_ninhada = filhotes_ninhada;
        this.data_cio = data_cio;
        this.rg = rg;
        this.nome_pai = nome_pai;
        this.nome_mãe = nome_mãe;
        this.meu = meu;
        this.genero = genero;
        this.favorito = favorito;
        this.vacina = vacina;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getComprimento() {
        return comprimento;
    }

    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCor1() {
        return cor1;
    }

    public void setCor1(String cor1) {
        this.cor1 = cor1;
    }

    public String getCor2() {
        return cor2;
    }

    public void setCor2(String cor2) {
        this.cor2 = cor2;
    }

    public String getTemperamento1() {
        return temperamento1;
    }

    public void setTemperamento1(String temperamento1) {
        this.temperamento1 = temperamento1;
    }

    public String getGetTemperamento2() {
        return getTemperamento2;
    }

    public void setGetTemperamento2(String getTemperamento2) {
        this.getTemperamento2 = getTemperamento2;
    }

    public String getTemperamento3() {
        return temperamento3;
    }

    public void setTemperamento3(String temperamento3) {
        this.temperamento3 = temperamento3;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public String getFilhotes_ninhada() {
        return filhotes_ninhada;
    }

    public void setFilhotes_ninhada(String filhotes_ninhada) {
        this.filhotes_ninhada = filhotes_ninhada;
    }

    public String getData_cio() {
        return data_cio;
    }

    public void setData_cio(String data_cio) {
        this.data_cio = data_cio;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNomemãe() {
        return nome_mãe;
    }

    public void setNomemãe(String nomemãe) {
        this.nome_mãe = nomemãe;
    }

    public String getNome_mãe() {
        return nome_mãe;
    }

    public void setNome_mãe(String nome_mãe) {
        this.nome_mãe = nome_mãe;
    }

    public int getMeu() {
        return meu;
    }

    public void setMeu(int meu) {
        this.meu = meu;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getVacina() {
        return vacina;
    }

    public void setVacina(int vacina) {
        this.vacina = vacina;
    }
}
