package ma.emsi.TpJPA.entities;

import java.util.Date;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity // Anotations JPA
@Table(name = "Patients")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5 , max = 15)
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    @DecimalMin("4") //validate score
    private int score;
}

