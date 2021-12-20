package chap_04_optional.ex03;

import chap_04_optional.data.Account;
import chap_04_optional.data.Person;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - Navigation avec map
 */
public class Optional_03_Test {

    // Soit une exception connue.
    class GoodException extends RuntimeException {
    }


    // TODO Implémenter la méthode findFirstname pour récupérer le prénom (account -> owner -> firstname)
    // Quelques indications :
    // - Utiliser la méthode map pour naviguer
    // - Utiliser la méthode orElseThrow pour déclencher l'exception GoodException si non trouvé
    private String findFirstname(Account account) throws GoodException {
        return null;
    }

    /**
     * Validation du cas où Account est null.
     * Déclenchement de GoodException attendu.
     * @throws Exception
     */
    @Test(expected = GoodException.class)
    public void test_getAccountNull() throws Exception {
        Account account = null;
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    /**
     * Validation du cas où Person est null.
     * Déclenchement de GoodException attendu.
     *
     * @throws Exception
     */
    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonNull() throws Exception {
        Account account = new Account(); // getOwner renvoie null
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    /**
     * Validation du cas où Firstname est null.
     * Déclenchement de GoodException attendu.
     *
     * @throws Exception
     */
    @Test(expected = GoodException.class)
    public void test_getAccountWithPersonFirstnameNull() throws Exception {
        Account account = new Account();
        account.setOwner(new Person()); // getFirstname() renvoie null
        String firstname = findFirstname(account); // devrait lancer une GoodException
        fail();
    }

    /**
     * Validation du cas où Firstname est valorisé.
     *
     * @throws Exception
     */
    @Test
    public void test_getAccountWithPersonFirstnameNotNull() throws Exception {
        Account account = new Account();
        account.setOwner(new Person("A", "B", 19, "C"));

        String firstname = findFirstname(account); // devrait lancer une GoodException
        assert firstname.equals("A");
    }
}
