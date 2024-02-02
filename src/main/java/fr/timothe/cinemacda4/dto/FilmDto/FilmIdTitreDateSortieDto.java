package fr.timothe.cinemacda4.dto.FilmDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmIdTitreDateSortieDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
}
