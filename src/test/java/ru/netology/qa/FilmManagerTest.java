package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {
    @Test
    public void shouldAddThreeFilms() {
        FilmManager manager = new FilmManager();
        Film film1 = new Film("Титаник", 1);
        Film film2 = new Film("Аватар", 2);
        Film film3 = new Film("Дом у озера", 3);

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);

        Film[] expected = {film1, film2, film3};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldAddOneFilms() {
        FilmManager manager = new FilmManager();
        Film film1 = new Film("Титаник", 1);

        manager.add(film1);

        Film[] expected = {film1};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldShowLastFilms() {
        FilmManager manager = new FilmManager();
        Film film1 = new Film("Титаник", 1);
        Film film2 = new Film("Аватар", 2);
        Film film3 = new Film("Дом у озера", 3);

        manager.add(film1);
        manager.add(film2);
        manager.add(film3);

        Film[] expected = {film3, film2, film1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected,actual);
    }

}
