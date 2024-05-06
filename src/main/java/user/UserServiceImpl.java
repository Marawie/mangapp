package user;

import exception.ExceptionEnum;
import exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RegistryWorkHoursRepository registryWorkHoursRepository;
    private final TeamGroupRepository teamGroupRepository;
    private final TaskIdentityRepository taskIdentityRepository;
    private final TypeWorkRepository typeWorkRepository;

    @Override
    public void registryWorkHours(
            RegistryWorkHoursRequest reportWorkHoursRequest,
            TypeWorkRequest typeWorkRequest,
            TaskIdentityRequest taskIdentityRequest,
            TeamGroupRequest teamGroupRequest,
            Long id) {

        final User user = userRepository.findById(id).orElseThrow(
                () -> new RestException(ExceptionEnum.USER_NOT_FOUND));

        final TaskIdentity taskIdentity = TaskIdentity.builder()
                .taskIdentityName(taskIdentityRequest.taskIdentityName())
                .taskIdentity(taskIdentityRequest.taskIdentity())
                .build();

        taskIdentityRepository.save(taskIdentity);

        final TypeWork typeWork = TypeWork.builder()
                .nameOfWorkType(typeWorkRequest.nameOfWorkType())
                .build();

        typeWorkRepository.save(typeWork);

        final TeamGroup teamGroup = TeamGroup.builder()
                .teamGroupName(teamGroupRequest.teamGroupName())
                .taskIdentities(Set.of(taskIdentity))
                .typeWorks(Set.of(typeWork))
                .build();

        teamGroupRepository.save(teamGroup);

        final RegistryWorkHours registryWorkHours = RegistryWorkHours.builder()
                .user(user)
                .commentary(reportWorkHoursRequest.commentary())
                .hours(reportWorkHoursRequest.hours())
                .dayToRegistry(reportWorkHoursRequest.dayToRegistry())
                .teamGroup(teamGroup)
                .build();

        registryWorkHoursRepository.save(registryWorkHours);

        user.setRegistryWorkHoursSet(Set.of(registryWorkHours));
        userRepository.save(user);
    }

    @Override
    public UserDto updateUser(UserDto updateUserRequest, Long id) {

        final User user = userRepository.findById(id).orElseThrow(
                () -> new RestException(ExceptionEnum.USER_NOT_FOUND));

        user.setAge(updateUserRequest.age());
        user.setEmail(updateUserRequest.email());
        user.setFirstname(updateUserRequest.firstname());
        user.setLastname(updateUserRequest.lastname());
        user.setRole(updateUserRequest.role());
        user.setSex(updateUserRequest.sex());

        userRepository.save(user);

        return UserMapper.INSTANCE.userToUserDto(user);
    }
}
