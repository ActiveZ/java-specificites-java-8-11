package chap_02_expression_lambda.ex04;


import chap_02_expression_lambda.data.Data;
import chap_02_expression_lambda.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Exercice 04 - FuncCollection
 * Exercice synthèse des exercices précédents
 */
public class Lambda_04_Test {

    // Soit les interfaces génériques que nous avons créées précedemment.

    interface GenericPredicate<T> {
        boolean test(T p);
    }

    interface GenericMapper<T, E> {
        E map(T a);
    }

    interface Processor<T> {
        void process(T p);
    }

    /**
     * Soit une structure basé sur une collection Java qui permet de bénéficier des méthodes "map", "filter" et "forEach".
     *
     * @param <T>
     */
    class FuncCollection<T> {

        private Collection<T> list = new ArrayList<>();

        public void add(T a) {
            list.add(a);
        }

        public void addAll(Collection<T> all) {
            for(T el:all) {
                list.add(el);
            }
        }

        private FuncCollection<T> filter(GenericPredicate<T> predicate) {
            FuncCollection<T> result = new FuncCollection<>();
            for (T p : list) {
                if (predicate.test(p)) {
                    result.add(p);
                }
            }
            return result;
        }

        private <E> FuncCollection<E> map(GenericMapper<T, E> mapper) {
            FuncCollection<E> result = new FuncCollection<>();

            for(T p : list) {
                result.add(mapper.map(p));
            }

            return result;
        }

        private void forEach(Processor<T> processor) {
            for(T p : list) {
                processor.process(p);
            }
        }


    }

    /**
     * Exemple d'utilisation d'une collection avec une approche fonctionnelle.
     *
     * @throws Exception
     */
    @Test
    public void test_filter_map_forEach() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);

        personFuncCollection
                // TODO filtrer, ne garder uniquement que les personnes ayant un age > 50
                .filter(null)
                // TODO transformer la liste de personnes en liste de comptes. Un compte a par défaut un solde à 1000.
                .map(null)
                // TODO vérifier que chaque compte a un solde à 1000.
                // TODO vérifier que chaque titulaire de compte a un age > 50
                .forEach(null);

        // TODO à supprimer
        assert false;
    }

    /**
     * Exemple de stockage d'une expression lambda dans une variable.
     *
     * @throws Exception
     */
    @Test
    public void test_filter_map_forEach_with_vars() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);

        // TODO créer un variable filterByAge de type GenericPredicate
        // TODO filtrer, ne garder uniquement que les personnes ayant un age > 50
        // ??? filterByAge = ???;

        // TODO créer un variable mapToAccount de type GenericMapper
        // TODO transformer la liste de personnes en liste de comptes. Un compte a par défaut un solde à 1000.
        // ??? mapToAccount = ???;

        // TODO créer un variable verifyAccount de type Processor
        // TODO vérifier que chaque compte a un solde à 1000.
        // TODO vérifier que chaque titulaire de compte a un age > 50
        // ??? verifyAccount = ???;

        /* TODO Décommenter
        personFuncCollection
                .filter(filterByAge)
                .map(mapToAccount)
                .forEach(verifyAccount);
        */

        // TODO A supprimer
        assert false;
    }



}
