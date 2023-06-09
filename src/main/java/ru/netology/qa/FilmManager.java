package ru.netology.qa;

public class FilmManager {


    private Film[] films = new Film[0];
    private int limit;

    public FilmManager(int limit) {
        if (limit >= 0) {
            this.limit = limit;
        } else {
            return;
        }
    }

    public FilmManager() {
        this.limit = 10;
    }

    public void add(Film film) {
        Film[] tmp = new Film[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;

    }

    public Film[] findAll() {
        return films;
    }

    public Film[] findLast() {
        int resultLength;
        if (films.length < limit) {
            resultLength = films.length;
        } else {
            resultLength = limit;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = films[films.length - 1 - i];

        }
        return result;
    }
}