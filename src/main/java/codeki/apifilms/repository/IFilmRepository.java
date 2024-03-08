package codeki.apifilms.repository;

import codeki.apifilms.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {

    // Método personalizado que busca películas por título
    // Retorna una lista con las películas que contienen en alguna parte de su título el String pasado por parámetro
    // Ignora mayúsculas y minúsculas
    List<Film> findByTitleContainingIgnoreCase(String title);

}
