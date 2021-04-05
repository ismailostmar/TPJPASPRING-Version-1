package ma.emsi.TpJPA.entities;


import java.util.Date;

import lombok.AllArgsConstructor; // Constructeur Avec Arguments
import lombok.Data; // Generer automatiquement les Get et Set à l'aide de @Data (AOP) Programmation orienté Aspect
import lombok.NoArgsConstructor; // Constructeur sans arguments
import lombok.ToString;

import javax.persistence.*;

@Entity // Anotations JPA
@Table(name = "Patients")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM",length = 25)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;

}

