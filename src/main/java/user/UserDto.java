package user;

import java.time.LocalDate;

record UserDto(String firstname,
               String lastname,
               LocalDate userCreated,
               String password,
               String confirmationPassword,
               String email,
               Role role,
               int age,
               Sex sex) {
}