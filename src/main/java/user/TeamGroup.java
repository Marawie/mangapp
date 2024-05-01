package user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
public class TeamGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamGroupName;

    @OneToMany(mappedBy = "teamGroup", cascade = CascadeType.ALL)
    private Set<TypeWork> typeWorks;

    @OneToMany(mappedBy = "teamGroup", cascade = CascadeType.ALL)
    private Set<TaskIdentity> taskIdentities;


    @OneToOne(mappedBy = "teamGroup", cascade = CascadeType.ALL)
    private RegistryWorkHours registryWorkHours;
}
