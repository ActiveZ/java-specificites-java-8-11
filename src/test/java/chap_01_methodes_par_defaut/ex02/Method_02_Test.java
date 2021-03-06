package chap_01_methodes_par_defaut.ex02;

import java.util.List;

import org.junit.Test;

import chap_01_methodes_par_defaut.data.Data;
import chap_01_methodes_par_defaut.data.Person;

/**
 * Exercice 02 - Redéfinition de méthodes par défaut.
 */
public class Method_02_Test {

    interface IDao {
        List<Person> findAll();

        // TODO créer une méthode String format()
        // TODO la méthode retourne une chaîne de la forme [<nb_personnes> persons]
        // TODO exemple de résultat : "[14 persons]", "[30 persons]"
        default String format() {
            return "[" + findAll().size() + " persons]";
        }
    }

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // TODO redéfinir la méthode String format()
        // TODO la méthode retourne une chaîne de la forme DaoA[<nb_personnes> persons]
        // TODO exemple de résultat : "DaoA[14 persons]", "DaoA[30 persons]"
        // TODO l'implémentation réutilise la méthode format() de l'interface

        @Override
        public String format() {
            return "DaoA" + IDao.super.format();
        }
    }

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode format() pour que le test soit passant
        String result = daoA.format();
        assert "DaoA[20 persons]".equals(result);
    }
}
