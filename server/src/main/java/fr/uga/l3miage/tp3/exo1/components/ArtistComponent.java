package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    // Operation CRUD

    // Create
    public ArtistEntity createArtist(ArtistEntity newArtist) {
        return artistRepository.save(newArtist);
    }

    // Read
    public ArtistEntity getArtist(String name) {
        return artistRepository.findById(name).orElseThrow();
    }

    //  ii. Récupérez le nombre d'artistes en fonction de leur genre musical.
    public Number getNumberOfArtistByGenre(GenreMusical genre) {
        return artistRepository.countArtistEntitiesByGenreMusical(genre);
    }

    // Update
    public ArtistEntity updateArtist(String name, ArtistEntity newArtist) {
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setName(newArtist.getName());
        artistEntity.setBiography(newArtist.getBiography());
        artistEntity.setGenreMusical(newArtist.getGenreMusical());
        artistEntity.setAlbumEntities(newArtist.getAlbumEntities());
        return artistRepository.save(artistEntity);
    }

    // Delete
    public void deleteArtist(String name) {
        artistRepository.deleteById(name);
    }



}
