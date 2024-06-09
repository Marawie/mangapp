package mangamentUserApp.user;

record UserDto(String firstname,
               String lastname,
               String password,
               String confirmationPassword,
               String email,
               Role role,
               int age,
               Sex sex) {
}