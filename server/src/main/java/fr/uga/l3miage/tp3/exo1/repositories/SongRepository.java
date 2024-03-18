package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, String> {

    //   i. Récupérez une chanson dont la durée est comprise dans un interval donné
    public SongEntity getSongEntityByDurationBetween(Duration min, Duration max);
}
