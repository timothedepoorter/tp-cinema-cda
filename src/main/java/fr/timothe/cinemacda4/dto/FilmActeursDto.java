package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmActeursDto {
    private List<ActeurDto> acteurs = new ArrayList<>();
}
