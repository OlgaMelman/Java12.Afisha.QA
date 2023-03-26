package ru.netology.qa;

public class FilmRepository {
    private Film[] films = new Film[0];

    public void save(Film film) {
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

    public Film[] findById(int id) {
        Film[] result = new Film[0];// тут будем хранить подошедшие запросу продукты
        for (Film film : films) {
            if (matches(film, id)) {
                Film[] tmp = new Film[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = film;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Film film, int search) {
        if (film.getId() == search) {
            return true;
        } else {
            return false;
        }
    }

    public void removeById(int id) {
        Film[] tmp = new Film[films.length - 1];
        int copyToIndex = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[copyToIndex] = film;
                copyToIndex++;
            }
        }
        films = tmp;
    }


    public Film[] removeAll() {
        Film[] delete = new Film[0];
        return delete;
    }
}
