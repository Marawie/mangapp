package user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
class TaskIdentityRequest {

    private String taskIdentityName;
    private int taskIdentity;
}
