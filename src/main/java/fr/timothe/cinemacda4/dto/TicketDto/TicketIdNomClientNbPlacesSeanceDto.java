package fr.timothe.cinemacda4.dto.TicketDto;

import fr.timothe.cinemacda4.dto.SeanceDto.SeanceIdDatePrixDto;
import lombok.Data;

@Data
public class TicketIdNomClientNbPlacesSeanceDto {
    private Integer id;
    private String nomClient;
    private Integer nombrePlaces;
    private SeanceIdDatePrixDto seance;
}
