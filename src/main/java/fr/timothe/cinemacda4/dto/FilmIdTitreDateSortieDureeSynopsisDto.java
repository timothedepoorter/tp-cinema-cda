package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilmIdTitreDateSortieDureeSynopsisDto {
    private Integer id;
    private String titre;
    private LocalDate dateSortie;
    private int duree;
    private String synopsis;
}