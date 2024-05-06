package user;

interface UserService {
    void registryWorkHours(RegistryWorkHoursRequest reportWorkHoursRequest,
                           TypeWorkRequest typeWorkRequest,
                           TaskIdentityRequest taskIdentityRequest,
                           TeamGroupRequest teamGroupRequest,
                           Long id);

    UserDto updateUser(UserDto updateUserRequest, Long id);
}
