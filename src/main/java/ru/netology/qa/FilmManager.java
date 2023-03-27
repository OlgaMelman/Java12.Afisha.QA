package ru.netology.qa;

public class FilmManager {
    private FilmRepository repo;

    public FilmManager(FilmRepository repo) {
       this.repo = repo;
    }


    public void add(Film film) {
       repo.save(film);

    }

    public Film[] findAll() {
        Film[] all = repo.findAll();
        return all;
    }

    public Film[] findLast() {
        int resultLength;
        if (repo.findAll().length < repo.getLimit()) {
            resultLength = repo.findAll().length;
        } else {
            resultLength = repo.getLimit();
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = repo.findAll()[repo.findAll().length - 1 - i];

        }
        return result;
    }


}