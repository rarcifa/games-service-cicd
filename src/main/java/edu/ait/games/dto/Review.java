package edu.ait.games.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewid;
    private Integer rating;
    private Integer Id;

    public Review() {
    }

    public Review(Integer reviewid, Integer rating, Integer Id) {
        this.reviewid = reviewid;
        this.rating = rating;
        this.Id = Id;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer gameid) {
        this.Id = gameid;
    }

    @Override public String toString() {
        return "Review{" + "reviewid=" + reviewid + ", rating=" + rating
                + ", gameid="
                + Id + '}';
    }
}
