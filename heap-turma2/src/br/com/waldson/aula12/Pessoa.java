package br.com.waldson.aula12;

import java.util.*;

public class Pessoa {
    private String nome;
    private int idade;

    private final List<Event> auxiliary = new ArrayList<>();


    public Pessoa(String nome, int idade) {
        this.nome  = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        int oldAge = this.getIdade();
        this.idade = idade;
        for(Event e : auxiliary){
            e.notifyEvent(this, oldAge);
        }
    }

    public void insertTheOther(FilaBanco fila){
        auxiliary.add(fila);
    }

    public void removeTheOther(FilaBanco fila){
        auxiliary.remove(fila);
    }
}
