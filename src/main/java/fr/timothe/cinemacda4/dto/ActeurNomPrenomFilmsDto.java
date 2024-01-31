package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurNomPrenomFilmsDto {
    private String nom;
    private String prenom;
    private List<FilmTitreDateSortieRealisateur> films = new ArrayList<>();
}
