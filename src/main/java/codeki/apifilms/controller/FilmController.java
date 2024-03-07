package codeki.apifilms.controller;

import codeki.apifilms.model.Film;
import codeki.apifilms.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/search/{id}")
    public Film findFilmById(@PathVariable Long id) {
        return filmService.findFilmById(id);
    }

    @GetMapping("/search-by-title/{title}")
    public List<Film> findFilmByTitle(@PathVariable String title) {
        return filmService.findFilmByTitle(title);
    }

    @PostMapping("/create")
    public String createFilm(@RequestBody Film film) {
        return filmService.createFilm(film);
    }

    @PutMapping("/update/{id}")
    public String updateFilm(@PathVariable Long id, @RequestBody Film film) {
        return filmService.updateFilm(id, film);
    }

    @PatchMapping("/update-price/{id}")
    public String updateFilmPrice(@PathVariable Long id, @RequestParam Double price) {
        return filmService.updateFilmPrice(id, price);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFilmById(@PathVariable Long id) {
        return filmService.deleteFilmById(id);
    }
}
