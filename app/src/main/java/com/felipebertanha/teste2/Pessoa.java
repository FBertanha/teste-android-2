package com.felipebertanha.teste2;

public class Pessoa {

    private String nome;
    private String sobrenome;

    public Pessoa(String nomeDigitado, String sobrenomeDigitado) {
        this.nome = nomeDigitado;
        this.sobrenome = sobrenomeDigitado;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
