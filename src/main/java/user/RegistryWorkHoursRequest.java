package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryWorkHoursRequest {

    private TeamGroup teamGroup;
    private int identityOfTask;
    private LocalDate dayToRegistry;
    private double hours;
    private String commentary;
    private TypeWork typeWork;

}
