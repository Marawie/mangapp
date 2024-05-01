package user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
public class TaskIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskIdentityName;

    private int taskIdentity;

    @ManyToOne
    @JoinColumn(name = "teamGroup_id")
    private TeamGroup teamGroup;
}
