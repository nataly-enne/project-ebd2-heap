package br.com.waldson.aula12;

import br.com.waldson.aula12.FilaBanco;
import br.com.waldson.aula12.Pessoa;

public class Main {

    public static void main(String[] args) {
        //Heap / Priority Queue
        FilaBanco fila = new FilaBanco();
        fila.insertPeople("Fulano", 20);
        fila.insertPeople("Sicrano", 10);
        fila.insertPeople("Vovó", 64);
        fila.insertPeople("Tio", 50);
        fila.insertPeople(new Pessoa("Beltrano", 5));

        while (fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println(p.getNome() + " está sendo atendido.");
            fila.remove();
        }

    }
}
