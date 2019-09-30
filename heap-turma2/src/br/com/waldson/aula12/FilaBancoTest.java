package br.com.waldson.aula12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilaBancoTest {

    FilaBanco fila = null;

    @Before
    public void init() {
        fila = new FilaBanco();
    }

    @Test
    public void mustBeOrdered() {
        //Arrange
        Pessoa vovo    = new Pessoa("Vovó", 65);
        Pessoa fulano  = new Pessoa("Fulano", 10);
        Pessoa sicrano = new Pessoa("Sicrano", 25);

        //Act
        fila.insertPeople(fulano);
        fila.insertPeople(vovo);
        fila.insertPeople(sicrano);

        //Assert
        assertSame(vovo, fila.peek());
        fila.remove();
        assertSame(sicrano, fila.peek());
        fila.remove();
        assertSame(fulano, fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void mustReorderWhenPriorityChange() {
        //Arrange
        Pessoa vovo    = new Pessoa("Vovó", 65);
        Pessoa fulano  = new Pessoa("Fulano", 10);
        Pessoa sicrano = new Pessoa("Sicrano", 25);
        fila.insertPeople(fulano);
        fila.insertPeople(vovo);
        fila.insertPeople(sicrano);

        //Act
        fulano.setIdade(67);

        //Assert
        assertSame(fulano, fila.peek());
    }

    @Test
    public void peekMustReturnAddedElement() {
        //Arrange
        Pessoa node  = new Pessoa("Fulano", 10);

        //Act
        fila.insertPeople(node);

        //Assert
        assertSame(node, fila.peek());
    }

    @Test
    public void mustBeInitializedEmpty() {
        //Assert
        assertNull(fila.peek());
    }

    @Test
    public void mustInsertPeopleByName() {
        //Arrange
        //Act
        fila.insertPeople("Nátaly", 20);
        //Assert
        assertEquals("Nátaly", fila.peek().getNome());
    }

    @Test
    public void mustInsertPeopleByObject() {
        //Arrange
        Pessoa p = new Pessoa("Nátaly", 20);
        //Act
        fila.insertPeople(p);
        //Assert
        assertSame(p, fila.peek());
    }

}