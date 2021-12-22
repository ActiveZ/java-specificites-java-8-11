package chap_02_expression_lambda.ex02;

import chap_02_expression_lambda.data.Account;
import chap_02_expression_lambda.data.Data;
import chap_02_expression_lambda.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Fonction de transformation map.
 */
public class Lambda_02_Test {

    interface PersonToAccountMapper {
        Account map(Person p);
    }

    private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
        List<Account> comptes = new ArrayList<>();
        for (Person p : personList) {
            Account monCompte = mapper.map(p);
        }
        return comptes;
    }


    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        PersonToAccountMapper m = p -> {
            Account monCompte = new Account();
            monCompte.setOwner(p);
            monCompte.setBalance(100);
            return monCompte;
        };

        List<Account> result = map(personList, m);

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }


    // Maintenant que le premier test est passant, vous avez compris la notion de map.
    // TODO pourriez-vous modifier PersonToAccountMapper (à renommer en GenericMapper) et la méthode map pour que
    // ces structures puissent s'utiliser avec d'autres classes que Person et Account.

    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms grâce aux structures génériques crées précedemment.
        List<String> result = null;

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
}
