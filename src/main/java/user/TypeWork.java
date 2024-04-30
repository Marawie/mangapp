package user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
public class TypeWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfWorkType;

    @ManyToOne
    @JoinColumn(name = "teamGroup_id")
    private TeamGroup teamGroup;

    @OneToOne(mappedBy = "typeWork")
    private RegistryWorkHours registryWorkHours;

}
