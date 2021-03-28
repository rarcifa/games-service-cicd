package edu.ait.gameCollection.model;

public class GameModel {
    private Integer id;
    private String name;
    private String cover;
    private String console;
    private String publisher;
    private String genre;
    private String releasedate;
    private Double metascore;
    private Double ignscore;
    private Integer igdbscore;
    private Double averageRating;
    private Long totalRating;
    private Long totalFollower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public Double getMetascore() {
        return metascore;
    }

    public void setMetascore(Double metascore) {
        this.metascore = metascore;
    }

    public Double getIgnscore() {
        return ignscore;
    }

    public void setIgnscore(Double ignscore) {
        this.ignscore = ignscore;
    }

    public Integer getIgdbscore() {
        return igdbscore;
    }

    public void setIgdbscore(Integer igdbscore) {
        this.igdbscore = igdbscore;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Long getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Long totalRating) {
        this.totalRating = totalRating;
    }

    public Long getTotalFollower() {
        return totalFollower;
    }

    public void setTotalFollower(Long totalFollower) {
        this.totalFollower = totalFollower;
    }
}
