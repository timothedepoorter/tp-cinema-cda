package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmTitreDureeDateSortieDto {
    private String titre;
    private LocalDate dateSortie;
    private int duree;
}