package fr.timothe.cinemacda4.dto.FilmDto;

import fr.timothe.cinemacda4.dto.RealisateurDto.RealisateurNomPrenomDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmTitreDateSortieRealisateurDto {
    private String titre;
    private LocalDate dateSortie;
    private RealisateurNomPrenomDto realisateur;
}