package chap_02_expression_lambda.ex01;

import chap_02_expression_lambda.data.Account;
import chap_02_expression_lambda.data.Data;
import chap_02_expression_lambda.data.Person;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 01 - Comprendre la notion de "Filtre".
 */
public class Lambda_01_Test {


    // Soit une interface représentant un prédicat :
    // => en entrée un objet
    // => en sortie un booléen
    interface PersonPredicate {
        boolean test(Person p);
    }

    interface GenericPredicate<T>{
        boolean test(T p);
    }

    /**
     * Soit une méthode permettant de filtrer une liste de personnes, c'est à dire à en garder qu'un sous-ensemble.
     *
     * @param persons   liste de personnes.
     * @param predicate un prédicat permettant d'exprimer les conditions du filtre
     * @return une nouvelle liste avec les personnes respectant les critères du prédicat.
     */
    private List<Person> filter(List<Person> persons, PersonPredicate predicate) {
        // TODO implementer la méthode
        List<Person> resultats = new ArrayList<>();
        for (Person p : persons) {
            if (predicate.test(p)) resultats.add(p);
        }
        return resultats;
    }


    /**
     * Ce premier test consiste à filtrer par age.
     *
     * @throws Exception
     */
    @Test
    public void test_filter_by_age() throws Exception {

        // Soit une liste de 100 personnes
        List<Person> personList = Data.buildPersonList(100);

        // TODO result ne doit contenir que des personnes adultes (age >= 18)
        List<Person> result = filter(personList, p -> p.getAge() >= 18);

        assert result.size() == 83;

        for (Person person : result) {
            assert person.getAge() > 17;
        }
    }

    /**
     * Filtre par prénom.
     *
     * @throws Exception
     */
    @Test
    public void test_filter_by_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO result ne doit contenir que des personnes dont le prénom est "first_10"
        List<Person> result = filter(personList, p -> p.getFirstname().equals("first_10"));

        assert result.size() == 1;
        assert result.get(0).getFirstname().equals("first_10");

    }

    /**
     * Filtre par mot de passe.
     *
     * @throws Exception
     */
    @Test
    public void test_filter_by_password() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // "test" hashé avec SHA-512
        String passwordSha512Hex = "ee26b0dd4af7e749aa1a8ee3c10ae9923f618980772e473f8819a5d4940e0db27ac185f8a0e1d5f84f88bc887fd67b143732c304cc5fa9ad8e6f57f50028a8ff";

        // TODO result ne doit contenir que les personnes dont l'age est > 49 et dont le hash du mot de passe correspond à la valeur de la variable passwordSha512Hex
        // TODO Pour obtenir le hash d'un mot, utiliser la méthode DigestUtils.sha512Hex(mot)
        List<Person> result = filter(personList, p -> p.getAge() > 49 && DigestUtils.sha512Hex(p.getPassword()).equals(passwordSha512Hex)
        );

        assert result.size() == 6;

        for (Person person : result) {
            assert person.getPassword().equals("test");
        }
    }

    // Maintenant tous les tests sont passants, vous avez compris la notion de filtre.
    // TODO pourriez-vous modifier PersonPredicate (à renommer en GenericPredicate) et la méthode filter pour que
    // ces structures puissent s'utiliser avec d'autres classes que Person.


}
