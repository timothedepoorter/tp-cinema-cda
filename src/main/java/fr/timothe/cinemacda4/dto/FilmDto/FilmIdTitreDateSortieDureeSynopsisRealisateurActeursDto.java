package fr.timothe.cinemacda4.dto.FilmDto;

import fr.timothe.cinemacda4.dto.ActeurDto.ActeurNomPrenomDto;
import fr.timothe.cinemacda4.entity.Realisateur;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmIdTitreDateSortieDureeSynopsisRealisateurActeursDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
    private Realisateur realisateur;
    private List<ActeurNomPrenomDto> acteurs = new ArrayList<>();
}
