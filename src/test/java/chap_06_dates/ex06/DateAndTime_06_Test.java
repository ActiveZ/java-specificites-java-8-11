package chap_06_dates.ex06;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 06 - Period
 */
public class DateAndTime_06_Test {

    @Test
    public void test_period() throws Exception {

        // TODO Créer une LocalDate au 31/12/2017
        LocalDate localDate1 = null;

        // TODO Créer une LocalDate au 01/01/2050
        LocalDate localDate2 = null;

        // TODO créer une période (classe java.time.Period) à entre les 2 précédentes dates
        Period result = null;

        assertThat(result.toTotalMonths(), is(384L));
    }
}
