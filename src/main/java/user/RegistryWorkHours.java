package user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Builder
public class RegistryWorkHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamGroup_id", referencedColumnName = "id")
    private TeamGroup teamGroup;

    private int identityOfTask;// przemyslec czy to tez nie bedzie encja/ raczej bedzie

    private LocalDate dayToRegistry;

    private double hours;

    private String commentary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeWork_id", referencedColumnName = "id")
    private TypeWork typeWork;
}
