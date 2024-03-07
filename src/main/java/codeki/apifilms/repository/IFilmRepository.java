package codeki.apifilms.repository;

import codeki.apifilms.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {

    List<Film> findByTitleContainingIgnoreCase(String title);

}
