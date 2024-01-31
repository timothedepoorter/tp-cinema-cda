package fr.timothe.cinemacda4.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "film")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Film {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private LocalDate dateSortie;

    @Column(nullable = false)
    private int duree;

    @Column(nullable = false, length = 500)
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "realisateur_id")
    private Realisateur realisateur;

    @ManyToMany
    @JoinTable(
            name = "acteur_film",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs = new ArrayList<>();
}
