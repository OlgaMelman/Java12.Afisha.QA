package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmManagerBorderTest {
    FilmRepository repo = new FilmRepository();
    FilmManager manager = new FilmManager(repo);
    Film film1 = new Film("Титаник", 1);
    Film film2 = new Film("Аватар", 2);
    Film film3 = new Film("Дом у озера", 3);
    Film film4 = new Film("Зеленая миля", 4);
    Film film5 = new Film("Бойцовский клуб", 5);
    Film film6 = new Film("Гарри Поттер 1", 6);
    Film film7 = new Film("Гарри Поттер 2", 7);
    Film film8 = new Film("Гарри Поттер 3", 8);
    Film film9 = new Film("Гарри Поттер 4", 9);

    @BeforeEach
    public void setup() {
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);
        manager.add(film6);
        manager.add(film7);
        manager.add(film8);
        manager.add(film9);
    }

    @Test
    public void shouldShowLast10Films() {
        Film film10 = new Film("Гарри Поттер 5", 10);

        manager.add(film10);

        Film[] expected = {film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast11Films() {
        Film film10 = new Film("Гарри Поттер 5", 10);
        Film film11 = new Film("Гарри Поттер 6", 11);

        manager.add(film10);
        manager.add(film11);

        Film[] expected = {film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast9Films() {
        Film[] expected = {film9, film8, film7, film6, film5, film4, film3, film2, film1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
