package chap_03_fonctions.ex01;

import chap_03_fonctions.data.Account;
import chap_03_fonctions.data.Person;
import org.junit.Test;

import java.util.function.Function;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PARTIE 1 - Integer -> Person *******/

    // TODO Compléter la définition de cette fonction
    // TODO Cette fonction permet de transformer un entier en objet Person
    // TODO le prenom sera de la forme "first_<ENTIER>"
    // TODO le nom sera de la forme "last_<ENTIER>"
    // TODO l'age sera de la forme "<ENTIER>"
    // TODO le mot de passe sera de la forme "pass_<ENTIER>"
    private Function<Integer, Person> intToPerson = null;

    /**
     * Validation de la fonction intToPerson.
     *
     * @throws Exception
     */
    @Test
    public void test_intToPerson() throws Exception {

        // TODO invoquer la fonction intToPerson avec en paramètre l'entier 10.
        Person result = null;

        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PARTIE 2 - Person -> Account *******/

    // TODO Compléter la définition de cette fonction
    // TODO la propriété owner est valorisé avec la personne en paramètre
    // TODO la propriété balance est valorisé à 1000
    private Function<Person, Account> personToAccount = null;

    /**
     * Validation de la fonction personToAccount.
     *
     * @throws Exception
     */
    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        // TODO invoquer la fonction personToAccount
        Account result = null;

        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }


    /******** PARTIE 3 - Integer -> Account avec compose *******/

    // TODO Compléter la définition de cette fonction
    // TODO Utiliser la méthode compose pour réutiliser les fonctions intToPerson et personToAccount
    private Function<Integer, Account> intToAccountWithCompose = null;


    /**
     * Validation de la fonction intToAccountWithCompose.
     *
     * @throws Exception
     */
    @Test
    public void test_intToAccount_with_Compose() throws Exception {

        // TODO invoquer la fonction intToAccountWithCompose avec l'entier 10
        Account result = null;

        assert result.getOwner().getFirstname().equals("first_10");
        assert result.getBalance().equals(1000);
    }

    /******** PARTIE 4 - Integer -> Account avec andThen *******/

    // TODO Compléter la définition de cette fonction
    // TODO Utiliser la méthode andThen pour réutiliser les fonctions intToPerson et personToAccount
    private Function<Integer, Account> intToAccountWithAndThen = null;

    /**
     * Validation de la fonction intToAccountWithAndThen.
     *
     * @throws Exception
     */
    @Test
    public void test_intToAccount_with_AndThen() throws Exception {

        // TODO invoquer la fonction intToAccountWithAndThen avec l'entier 11
        Account result = null;

        assert result.getOwner().getFirstname().equals("first_11");
        assert result.getBalance().equals(1000);
    }
}
