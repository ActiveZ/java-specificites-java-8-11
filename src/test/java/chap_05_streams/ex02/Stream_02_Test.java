package chap_05_streams.ex02;

import chap_05_streams.data.Data;
import chap_05_streams.data.domain.Customer;
import chap_05_streams.data.domain.Order;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

    @Test
    public void test_map() throws Exception {

        List<Order> orders = new Data().getOrders();

        // Trouver la liste des clients ayant déjà passés une commande
        List<Customer> result = null;

        assertThat(result, hasSize(2));
    }

    @Test
    public void test_flatmap() throws Exception {

        List<Order> orders = new Data().getOrders();

        // TODO calculer les statistiques sur les prix des pizzas vendues
        // TODO utiliser l'opération summaryStatistics
        IntSummaryStatistics result = null;


        assertThat(result.getSum(), is(10900L));
        assertThat(result.getMin(), is(1000));
        assertThat(result.getMax(), is(1375));
        assertThat(result.getCount(), is(9L));
    }
}
