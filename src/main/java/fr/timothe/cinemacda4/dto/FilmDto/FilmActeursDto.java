package fr.timothe.cinemacda4.dto.FilmDto;

import fr.timothe.cinemacda4.dto.ActeurDto.ActeurNomPrenomDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmActeursDto {
    private List<ActeurNomPrenomDto> acteurs = new ArrayList<>();
}
