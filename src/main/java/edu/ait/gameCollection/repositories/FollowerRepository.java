package edu.ait.gameCollection.repositories;

import edu.ait.gameCollection.dto.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}
