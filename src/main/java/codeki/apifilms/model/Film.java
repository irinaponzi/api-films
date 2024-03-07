package codeki.apifilms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String productionCompany;
    private LocalDate releaseDate;
    private Integer runningTime;
    private String country;
    private Double price;

    // Constructores
    public Film() {

    }

    public Film(Long id, String title, String director, String productionCompany, LocalDate releaseDate, Integer runningTime, String country, Double price) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.productionCompany = productionCompany;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.country = country;
        this.price = price;
    }

    public Film(String title, String director, String productionCompany, LocalDate releaseDate, Integer runningTime, String country, Double price) {
        this.title = title;
        this.director = director;
        this.productionCompany = productionCompany;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.country = country;
        this.price = price;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public String getCountry() {
        return country;
    }

    public Double getPrice() {
        return price;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
