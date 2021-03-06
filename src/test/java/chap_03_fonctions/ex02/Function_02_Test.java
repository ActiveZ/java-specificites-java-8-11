package chap_03_fonctions.ex02;

import chap_03_fonctions.data.Account;
import chap_03_fonctions.data.Person;
import org.junit.Test;

import java.util.function.BiFunction;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

    // TODO Compléter la fonction buildAccount
    // TODO la fonction possède 2 paramètres en entrée : une personne et un solde
    BiFunction<Person, Integer, Account> buildAccount = null;

    /**
     * Validation de la fonction buildAccount.
     * @throws Exception
     */
    @Test
    public void test_build_account() throws Exception {

        // TODO invoquer la fonction buildAccount pour que le test soit passant
        Account account = null;

        assert account.getBalance().equals(500);
        assert account.getOwner().getFirstname().equals("John");
        assert account.getOwner().getLastname().equals("France");
        assert account.getOwner().getAge().equals(80);
        assert account.getOwner().getPassword().equals("pass");
    }


}
