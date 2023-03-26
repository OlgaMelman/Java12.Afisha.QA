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


}