package fr.timothe.cinemacda4.dto.SeanceDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceIdDatePrixDto {
    private Integer id;
    private LocalDate date;
    private Float prix;
}
