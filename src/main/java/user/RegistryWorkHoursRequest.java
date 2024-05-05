package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
class RegistryWorkHoursRequest {
    private LocalDate dayToRegistry;
    private double hours;
    private String commentary;
}
