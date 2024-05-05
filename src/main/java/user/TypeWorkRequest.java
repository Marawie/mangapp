package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
class TypeWorkRequest {
    private String nameOfWorkType;
}
