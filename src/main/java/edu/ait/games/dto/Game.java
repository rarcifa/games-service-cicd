package edu.ait.games.dto;

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
    private String publisher;
    private String genre;
    private String releasedate;
    private String metascore;
    private String ignscore;

    @OneToMany
    @JoinColumn(name = "Id")
    private List<edu.ait.games.dto.Review> review;

    @OneToMany
    @JoinColumn(name = "follower_id")
    private List<edu.ait.games.dto.Follower> follower;
    public Game() {
    }

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


    // List Setter for Reviews
    public List<edu.ait.games.dto.Review> getReview() {
        return review;
    }

    public void setReview(List<edu.ait.games.dto.Review> review) {
        this.review = review;
    }

    // List Setter for Follower
    public List<edu.ait.games.dto.Follower> getFollower() {
        return follower;
    }

    public void setFollower(List<edu.ait.games.dto.Follower> follower) {
        this.follower = follower;
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
