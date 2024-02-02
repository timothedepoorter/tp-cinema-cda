package fr.timothe.cinemacda4.dto.SeanceDto;

import fr.timothe.cinemacda4.dto.SalleDto.SalleIdNumCapaciteDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceIdDatePrixPlacesDisposSalleDto {
    private Integer id;
    private LocalDate date;
    private Float prix;
    private Integer placesDisponibles;
    private SalleIdNumCapaciteDto salle;
}
