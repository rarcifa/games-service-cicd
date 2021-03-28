package edu.ait.gameCollection.dto;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "items")
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String cover;
    private String console;
    private String publisher;
    private String genre;
    private String releasedate;
    private String metascore;
    private String ignscore;
    private String igdbscore;
    //@Lob
    //private String description1;
    @OneToMany
    @JoinColumn(name = "Id")
    private List<Review> review;

    @OneToMany
    @JoinColumn(name = "follower_id")
    private List<Follower> follower;
    public Game() {
    }

    public Game(Integer id, String name, String publisher, String genre, String releasedate, String cover, String console, String metascore, String ignscore, String igdbscore) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.genre = genre;
        this.releasedate = releasedate;
        this.cover = cover;
        this.console = console;
        this.metascore = metascore;
        this.ignscore = ignscore;
        this.igdbscore = igdbscore;
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

    public String getCover() {
        return cover;
    }

    public String getConsole() {
        return console;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getIgnscore() {
        return ignscore;
    }

    public String getIgdbscore() {
        return igdbscore;
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

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public void setMetascore(String metascore) {
        this.cover = metascore;
    }

    public void setIgnscore(String ignscore) {
        this.console = ignscore;
    }

    public void setIgdbscore(String igdbscore) {
        this.console = igdbscore;
    }

    // List Setter for Reviews
    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    // List Setter for Follower
    public List<Follower> getFollower() {
        return follower;
    }

    public void setFollower(List<Follower> follower) {
        this.follower = follower;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", console='" + console + '\'' +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", releasedate='" + releasedate + '\'' +
                ", metascore='" + metascore + '\'' +
                ", ignscore='" + ignscore + '\'' +
                ", igdbscore='" + igdbscore + '\'' +
                '}';
    }
}
