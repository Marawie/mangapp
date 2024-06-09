package mangamentUserApp.user;

import java.time.LocalDate;

record RegistryWorkHoursRequest(LocalDate dayToRegistry, double hours, String commentary) {}