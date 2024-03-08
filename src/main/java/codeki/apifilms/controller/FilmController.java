package codeki.apifilms.controller;

import codeki.apifilms.model.Film;
import codeki.apifilms.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    // Inyección de dependencia del servicio
    @Autowired
    private FilmService filmService;

    // Obtener todas las películas
    @GetMapping("")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    // Buscar película por ID
    @GetMapping("/search/{id}")
    public Film findFilmById(@PathVariable Long id) {
        return filmService.findFilmById(id);
    }

    // Buscar película por título
    @GetMapping("/search-by-title/{title}")
    public List<Film> findFilmByTitle(@PathVariable String title) {
        return filmService.findFilmByTitle(title);
    }

    // Crear película
    @PostMapping("/create")
    public Film createFilm(@RequestBody Film film) {
        return filmService.createFilm(film);
    }

    // Actualizar película
    @PutMapping("/update/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film film) {
        return filmService.updateFilm(id, film);
    }

    // Eliminar película
    @DeleteMapping("/delete/{id}")
    public void deleteFilmById(@PathVariable Long id) {
        filmService.deleteFilmById(id);
    }
}
