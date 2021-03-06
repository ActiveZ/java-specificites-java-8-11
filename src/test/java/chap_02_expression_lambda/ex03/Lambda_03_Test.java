package chap_02_expression_lambda.ex03;

import chap_02_expression_lambda.data.Data;
import chap_02_expression_lambda.data.Person;
import org.junit.Test;

import java.util.List;

/**
 * Exercice 03 - ForEach
 */
public class Lambda_03_Test {

    interface Processor<T> {
        void process(T p);
    }

    private <T> void forEach(List<T> source, Processor<T> processor) {
       // TODO appliquer le traitement défini par le "processor" à chacun des éléments de la source
    }


    @Test
    public void test_verify_person() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO vérifier qu'une personne à un prénom qui commence par first
        // TODO vérifier qu'une personne à un nom qui commence par last
        // TODO vérifier qu'une personne à un age > 0
        // TODO la vérification se fait via une assertion (mot clé assert)
        Processor<Person> verifyPerson = null;

        assert verifyPerson != null;

        forEach(personList, verifyPerson);
    }

}
