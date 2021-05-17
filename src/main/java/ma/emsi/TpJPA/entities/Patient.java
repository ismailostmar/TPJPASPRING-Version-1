package ma.emsi.TpJPA.entities;

import java.util.Date;
import lombok.*;
import javax.persistence.*;

@Entity // Anotations JPA
@Table(name = "Patients")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(nullable = false)
    private boolean malade;
}

