package fr.timothe.cinemacda4.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurWithFilmsDto {
    private Integer id;
    private String nom;
    private String prenom;
    private List<FilmsReduitsDto> films = new ArrayList<>();
}
