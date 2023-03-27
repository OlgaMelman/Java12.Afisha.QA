package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class FilmManagerTest {
    FilmRepository repo = Mockito.mock(FilmRepository.class);
    FilmManager manager = new FilmManager(repo);

    @Test
    public void shouldShowEmpty() {
        Film[] films = new Film[0];
        doReturn(films).when(repo).findAll();

        Film[] expected = new Film[0];
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneFilms() {
        Film film1 = new Film("Титаник", 1);
        Film[] films = {film1};
        doReturn(films).when(repo).findAll();

        Film[] expected = {film1};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeFilms() {
        Film film1 = new Film("Титаник", 1);
        Film film2 = new Film("Аватар", 2);
        Film film3 = new Film("Дом у озера", 3);
        Film[] films = {film1, film2, film3};
        doReturn(films).when(repo).findAll();

        Film[] expected = {film1, film2, film3};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllFilms() {
        Film film1 = new Film("Титаник", 1);
        Film film2 = new Film("Аватар", 2);
        Film film3 = new Film("Дом у озера", 3);
        Film[] films = {film1, film2, film3};
        doReturn(new Film[0]).when(repo).removeAll();

        Film[] expected = new Film[0];
        Film[] actual = repo.removeAll();
        ;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Film film1 = new Film("Титаник", 1);
        Film film2 = new Film("Аватар", 2);
        Film film3 = new Film("Дом у озера", 3);
        Film[] films = {film1, film2, film3};
        doReturn(new Film[2]).when(repo).findById(3);

        Film[] expected = new Film[2];
        Film[] actual = repo.findById(3);

        Assertions.assertArrayEquals(expected,actual);
    }

}
