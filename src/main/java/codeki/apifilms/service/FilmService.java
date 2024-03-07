package codeki.apifilms.service;

import codeki.apifilms.model.Film;
import codeki.apifilms.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private IFilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film findFilmById(Long id) {
        Optional<Film> film = filmRepository.findById(id);
        return film.orElseGet(null); // esto ver
    }

    public List<Film> findFilmByTitle(String title) {
        List<Film> filmList = filmRepository.findByTitleContainingIgnoreCase(title);
        if(!filmList.isEmpty()) {
            return filmList;
        } else {
            return null; // esto ver
        }
    }

    public String createFilm(Film film) {
        filmRepository.save(film);
        return "La película se creó con éxito";
    }

    public String updateFilm(Long id, Film film) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            film.setId(id);
            filmRepository.save(film);
            return "La película " + id + " se actualizó con éxito";
        } else {
            return "La película " + id + " no se encontró";
        }
    }

    public String updateFilmPrice(Long id, Double price) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            Film filmExist = filmOptional.get();
            filmExist.setPrice(price);
            filmRepository.save(filmExist);
            return "El precio de la película " + id + " se actualizó con éxito";
        } else {
            return "La película " + id + " no se encontró";
        }
    }

    public String deleteFilmById(Long id) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if(filmOptional.isPresent()) {
            filmRepository.deleteById(id);
            return "La película " + id + " se eliminó con éxito";
        } else
            return "La película " + id + " no se encontró";
    }
}
