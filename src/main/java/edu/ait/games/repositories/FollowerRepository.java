package edu.ait.games.repositories;

import edu.ait.games.dto.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}
