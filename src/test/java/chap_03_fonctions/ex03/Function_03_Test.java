package chap_03_fonctions.ex03;

import chap_03_fonctions.data.Person;
import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test {

    // TODO Compléter la fonction makeAChild
    // TODO l'enfant possède le nom du père
    // TODO l'enfant possède le prenom "<PRENOM_PERE> <PRENOM_MERE>"
    // TODO l'age de l'enfant est 0
    // TODO le mot de passe de l'enfant est null
    BinaryOperator<Person> makeAChild = null;

    /**
     * Validation de la fonction makeAChild.
     * @throws Exception
     */
    @Test
    public void test_makeAChild() throws Exception {

        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        // TODO compléter le test pour qu'il soit passant
        Person child = null;

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }

}
