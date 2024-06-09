package mangamentUserApp.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mangamentUserApp.user.Sex;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class RegisterRequest {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Sex sex;
    private String token;
}