package chap_05_streams.ex01;

import chap_05_streams.data.Data;
import chap_05_streams.data.domain.Order;
import chap_05_streams.data.domain.Pizza;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

    @Test
    public void test_stream_filter() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // TODO récupérer la liste des pizzas dont le prix est >= 1300
        // TODO utiliser l'API Stream
        List<Pizza> result = pizzas.stream()
                .filter(pizza -> pizza.getPrice() >= 1300)
                .collect(Collectors.toList());

        assertThat(result, hasSize(3));
        assertThat(result, everyItem(hasProperty("price", anyOf(equalTo(1300), greaterThan(1300)))));
    }

    @Test
    public void test_stream_anyMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        // TODO valider si au moins une pizza à un prix >= 1300
        Boolean result1 = pizzas.stream()
                .anyMatch(pizza -> pizza.getPrice() >= 1300);

        // TODO valider si au moins une pizza à un prix >= 2000
        Boolean result2 = pizzas.stream()
                .anyMatch(pizza -> pizza.getPrice() >= 2000);

        assertThat(result1, is(true));
        assertThat(result2, is(false));
    }

    @Test
    public void test_stream_allMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        // TODO valider que toutes les pizzas ont un prix >= 1300
        Boolean result1 = pizzas.stream()
                .allMatch(pizza -> pizza.getPrice() >= 1300);

        // TODO valider que toutes les pizzas ont un prix >= 900
        Boolean result2 = pizzas.stream()
                .allMatch(pizza -> pizza.getPrice() >= 900);

        assertThat(result1, is(false));
        assertThat(result2, is(true));
    }


    @Test
    public void test_stream_noneMatch() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        // TODO valider qu'aucune pizza n'a un prix >= 2000
        Boolean result1 = pizzas.stream()
                .noneMatch(pizza -> pizza.getPrice() >= 2000);

        assertThat(result1, is(true));
    }

    @Test
    public void test_stream_filter_and_match() throws Exception {

        List<Order> orders = new Data().getOrders();

        // TODO récupérer toutes les commandes dont
        // TODO le prénom du client est "Johnny"
        // TODO dont au moins une pizza a un prix >= 1300
        List<Order> result = orders.stream()
                .filter(order -> order.getCustomer().getFirstname().equals("Johnny"))
                .filter(order -> order.getPizzas().stream()
                        .anyMatch(pizza -> pizza.getPrice() >= 1300))
                .collect(Collectors.toList());

        assertThat(result, hasSize(1));
        assertThat(result.get(0), hasProperty("id", is(8)));
    }

    @Test
    public void test_stream_findFirst() throws Exception {
        List<Order> orders = new Data().getOrders();

        // TODO récupérer une commande faite par un client dont le prénom est "Sophie"
        Optional<Order> result = orders.stream()
                .filter(order -> order.getCustomer().getFirstname().equals("Sophie"))
                .findFirst();

        assertThat(result.isPresent(), is(false));
    }

    @Test
    public void test_stream_max() throws Exception {
        List<Pizza> pizzas = new Data().getPizzas();

        // TODO Trouver la pizza la plus chère
        Optional<Pizza> result = pizzas.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrice)));

        // ou bien
        result = pizzas.stream().max(Comparator.comparing(Pizza::getPrice));

        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), hasProperty("id", is(5)));
        assertThat(result.get(), hasProperty("name", is("La Cannibale")));
        assertThat(result.get(), hasProperty("price", is(1550)));
    }

    @Test
    public void test_stream_min() throws Exception {

        List<Pizza> pizzas = new Data().getPizzas();

        // TODO Trouver la pizza la moins chère dont le prix est >= 950
        Optional<Pizza> result = pizzas.stream()
                .filter(pizza -> pizza.getPrice() >= 950)
                .collect(Collectors.minBy(Comparator.comparingInt(Pizza::getPrice)));

        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), hasProperty("id", is(3)));
        assertThat(result.get(), hasProperty("name", is("La Reine")));
        assertThat(result.get(), hasProperty("price", is(1000)));
    }
}
