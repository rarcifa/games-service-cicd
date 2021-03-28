package edu.ait.games.dto;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "items")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String publisher;
    private String genre;
    private String releasedate;
    private String metascore;
    private String ignscore;

    public Game(Integer id, String name, String publisher, String genre, String releasedate, String metascore, String ignscore) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.genre = genre;
        this.releasedate = releasedate;
        this.metascore = metascore;
        this.ignscore = ignscore;
    }

    // Setters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getIgnscore() {
        return ignscore;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public void setIgnscore(String ignscore) {
        this.ignscore = ignscore;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", metascore='" + metascore + '\'' +
                ", ignscore='" + ignscore + '\'' +
                '}';
    }
}
