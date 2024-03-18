package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@AllArgsConstructor
public class SongComponent {
    public final SongRepository songRepository;

    // Definition des opérations CRUD

    // Create
    public SongEntity createSong(SongEntity songEntity) {
        return songRepository.save(songEntity);
    }

    // Read
    public SongEntity getSong(String title) {
        return songRepository.findById(title).orElseThrow();
    }

    //   i. Récupérez une chanson dont la durée est comprise dans un interval donné (peux être pas ici !)
    public SongEntity getSongDurationIsInRange(Duration min, Duration max) {
        return songRepository.getSongEntityByDurationBetween(min, max);
    }



    // Update
    public SongEntity updateSong(String title, SongEntity newSongEntity) {
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setTitle(newSongEntity.getTitle());
        songEntity.setDuration(newSongEntity.getDuration());
        songEntity.setAlbumEntity(newSongEntity.getAlbumEntity());
        songEntity.setArtistEntity(newSongEntity.getArtistEntity());
        return songRepository.save(songEntity);
    }

    // Delete
    public void deleteSong(String title) {
        songRepository.deleteById(title);
    }
}
