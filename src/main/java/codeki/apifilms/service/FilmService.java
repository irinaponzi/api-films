package codeki.apifilms.service;

import codeki.apifilms.model.Film;
import codeki.apifilms.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    // Inyección de dependencia del repositorio
    @Autowired
    private IFilmRepository filmRepository;

    // Obtiene todas las películas
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Busca una película por ID
    // En caso de que no sea encontrada devuelve un null
    public Film findFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    // Busca películas por título
    // En caso de no encontrarse resultados devuelve una lista vacía
    public List<Film> findFilmByTitle(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    // Crea una película nueva y la retorna
    public Film createFilm(Film film) {
        filmRepository.save(film);
        return film;
    }

    // Actualiza una película y la retorna. Recibe un film con todos sus atributos, incluído su ID.
    // En caso de que la película no sea encontrada, la crea.
    public Film updateFilm(Film film) {
        filmRepository.save(film);
        return film;
    }

    /*  Método para el update, buscando antes el film por ID

    public Film updateFilm(Long id, Film film) {
        Optional<Film> filmOptional = filmRepository.findById(id);
        if (filmOptional.isPresent()) {
            film.setId(id);
            filmRepository.save(film);
            return film;
        }
        throw new NoSuchElementException("La película no fue encontrada");
    }
    */

    // Elimina una película según su ID
    // En caso de que no sea encontrada no se realiza la eliminación
    public void deleteFilmById(Long id) {
        filmRepository.deleteById(id);
    }
}
