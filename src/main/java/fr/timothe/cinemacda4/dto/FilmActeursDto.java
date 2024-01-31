package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmActeursDto {
    private List<ActeurNomPrenomDto> acteurs = new ArrayList<>();
}
