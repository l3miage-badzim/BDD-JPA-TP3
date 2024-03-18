package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    // Definition des opérations CRUD (Create Read Update Delete)

    // Create
    public PlaylistEntity createPlaylist() {
    PlaylistEntity playlist = PlaylistEntity
            .builder()
            .name("new playlist")
            .totalDuration(Duration.ZERO)
            .songEntities(Set.of())
            .build();
    return playlistRepository.save(playlist);
    }

    // Read
    public PlaylistEntity getPlaylist(String name) {
        return playlistRepository.findById(name).orElseThrow();
    }

    // Je spécifie des Read Spécifique ici comme

    // iii. Récupérez toutes les playlists, sans doublons qui ont une chanson particulière
    public Set<PlaylistEntity> getPLaylistsHasSong(SongEntity song) {
        return playlistRepository.getDistinctBySongEntitiesContaining(song);
    }


    // Update
    // approche beaucoup plus générique !
    public PlaylistEntity update(String playlistName, PlaylistEntity newPlaylistEntity) {
        PlaylistEntity playlist = playlistRepository.findById(playlistName).orElseThrow();
        playlist.setName(newPlaylistEntity.getName());
        playlist.setDescription(newPlaylistEntity.getDescription());
        playlist.setTotalDuration(newPlaylistEntity.getTotalDuration());
        playlist.setSongEntities(newPlaylistEntity.getSongEntities());
        return playlistRepository.save(playlist);
    }

    // Delete
    public void delete(String playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
