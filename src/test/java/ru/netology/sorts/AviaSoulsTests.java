package ru.netology.sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTests {
    AviaSouls aviaSoul = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "SPb", 3000, 6, 9);
    Ticket ticket2 = new Ticket("Moscow", "Adler", 6000, 12, 16);
    Ticket ticket3 = new Ticket("Moscow", "Adler", 5000, 2, 5);
    Ticket ticket4 = new Ticket("Irkutsk", "Moscow", 20000, 11, 18);
    Ticket ticket5 = new Ticket("Moscow", "Adler", 8000, 20, 23);
    Ticket ticket6 = new Ticket("Habarovsk", "SPb", 25000, 8, 16);
    Ticket ticket7 = new Ticket("Moscow", "Adler", 6000, 10, 12);

    @Test
    public void sortFewTicketsForPriceTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);

        Ticket[] actual = aviaSoul.search("Moscow", "Adler");
        Ticket[] expected = {ticket3, ticket2, ticket7, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketForPriceTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);

        Ticket[] actual = aviaSoul.search("Irkutsk", "Moscow");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketForPriceTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);

        Ticket[] actual = aviaSoul.search("SPb", "Moscow");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortFewTicketsForTimeTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSoul.searchAndSortBy("Moscow", "Adler", comparator);
        Ticket[] expected = {ticket7, ticket3, ticket5, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTicketForTimeTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSoul.searchAndSortBy("Moscow", "SPb", comparator);
        Ticket[] expected = {ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortZeroTicketForTimeTest () {
        AviaSouls aviaSoul = new AviaSouls();
        aviaSoul.add(ticket1);
        aviaSoul.add(ticket2);
        aviaSoul.add(ticket3);
        aviaSoul.add(ticket4);
        aviaSoul.add(ticket5);
        aviaSoul.add(ticket6);
        aviaSoul.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = aviaSoul.searchAndSortBy("SPb", "Moscow", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
