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

    private LocalDate dayToRegistry;

    private double hours;

    private String commentary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
