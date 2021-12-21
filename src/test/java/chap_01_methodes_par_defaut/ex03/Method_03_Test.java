package chap_01_methodes_par_defaut.ex03;

import java.util.List;

import org.junit.Test;

import chap_01_methodes_par_defaut.data.Data;
import chap_01_methodes_par_defaut.data.Person;

/**
 * Exercice 03 - Méthode statique
 */
public class Method_03_Test {

    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode statique IDao getDefaultInstance()
        // TODO cette méthode retourne une instance de la classe DaoA

        static IDao getDefaultInstance(){
            return new DaoA();
        }
    }

    static class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

    }

    @Test
    public void test_getDefaultInstance() throws Exception {
        // TODO invoquer la méthode getDefaultInstance() pour que le test soit passant
        IDao result = IDao.getDefaultInstance();

        assert result.findAll().size() == 20;
    }
}
