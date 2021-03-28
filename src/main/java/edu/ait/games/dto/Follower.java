package edu.ait.games.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_follower")
public class Follower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer f_id;
    private Integer follower_id;
    private Integer follower_userid;

    public Follower() {
    }

    public Follower(Integer f_id, Integer follower_id, Integer follower_userid) {
        this.f_id = f_id;
        this.follower_id = follower_id;
        this.follower_userid = follower_userid;
    }

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public Integer follower_id() {
        return follower_id;
    }

    public void setFollower_Id(Integer follower_id) {
        this.follower_id = follower_id;
    }

    public Integer getFollower_userId() {
        return follower_userid;
    }

    public void setFollower_userId(Integer follower_userid) {
        this.follower_userid = follower_userid;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "f_id=" + f_id +
                ", follower_id=" + follower_id +
                ", follower_userid=" + follower_userid +
                '}';
    }
}
