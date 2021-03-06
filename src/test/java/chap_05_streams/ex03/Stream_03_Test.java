package chap_05_streams.ex03;

import chap_05_streams.data.Data;
import chap_05_streams.data.domain.Customer;
import chap_05_streams.data.domain.Gender;
import chap_05_streams.data.domain.Order;
import chap_05_streams.data.domain.Pizza;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 03 - Collectors
 */
public class Stream_03_Test {

    @Test
    public void test_joining() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // TODO construire une chaîne contenant les prénoms des clients triés et séparé par le caractère "|"
        String result = null;

        assertThat(result, is("Alexandra|Cyril|Johnny|Marion|Sophie"));
    }

    @Test
    public void test_grouping() throws Exception {

        List<Order> orders = new Data().getOrders();

        // TODO construire une Map <Client, Commandes effectuées par le client
        Map<Customer, List<Order>> result = null;

        assertThat(result.size(), is(2));
        assertThat(result.get(new Customer(1)), hasSize(4));
        assertThat(result.get(new Customer(2)), hasSize(4));
    }

    @Test
    public void test_partitionning() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // TODO Séparer la liste des pizzas en 2 ensembles :
        // TODO true -> les pizzas dont le nom commence par "L"
        // TODO false -> les autres
        Map<Boolean, List<Pizza>> result = null;

        assertThat(result.get(true), hasSize(6));
        assertThat(result.get(false), hasSize(2));
    }

    @Test
    public void test_mapping() throws Exception {

        List<Customer> customers = new Data().getCustomers();

        // TODO Construire la map Sexe -> Chaîne représentant les prénoms des clients
        Map<Gender, String> result = null;

        assertThat(result.get(Gender.F), is("Alexandra|Marion|Sophie"));
        assertThat(result.get(Gender.M), is("Cyril|Johnny"));
    }
}
