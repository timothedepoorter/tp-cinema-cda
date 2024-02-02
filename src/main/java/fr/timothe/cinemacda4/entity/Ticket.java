package fr.timothe.cinemacda4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nomClient;

    @Column(nullable = false)
    private Integer nombrePlaces;

    @ManyToOne
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;
}
