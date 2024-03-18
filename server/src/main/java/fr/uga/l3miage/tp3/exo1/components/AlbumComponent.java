package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    // Operation CRUD

    // Create
    public AlbumEntity createAlbum(AlbumEntity newAlbum) {
        return albumRepository.save(newAlbum);
    }

    // Read
    public AlbumEntity getAlbum(String title) {
        return albumRepository.findById(title).orElseThrow();
    }

    // Update
    public AlbumEntity updateAlbum(String title, AlbumEntity newAlbum) {
        AlbumEntity albumEntity = albumRepository.findById(title).orElseThrow();
        albumEntity.setTitle(newAlbum.getTitle());
        albumEntity.setReleaseDate(newAlbum.getReleaseDate());
        albumEntity.setSongEntities(newAlbum.getSongEntities());
        albumEntity.setArtistEntity(newAlbum.getArtistEntity());
        return albumRepository.save(albumEntity);
    }

    // Delete
    public void deleteAlbum(String title) {
        albumRepository.deleteById(title);
    }
}
