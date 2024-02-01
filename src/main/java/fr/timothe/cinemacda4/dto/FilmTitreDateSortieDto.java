package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmTitreDateSortieDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
}
