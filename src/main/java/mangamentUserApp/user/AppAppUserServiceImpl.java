package mangamentUserApp.user;

import mangamentUserApp.exception.ExceptionEnum;
import mangamentUserApp.exception.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

import static mangamentUserApp.user.Role.APP_USER;

@Service
@RequiredArgsConstructor
class AppAppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
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

        final AppUser user = appUserRepository.findById(id).orElseThrow(
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
                .appUser(user)
                .commentary(reportWorkHoursRequest.commentary())
                .hours(reportWorkHoursRequest.hours())
                .dayToRegistry(reportWorkHoursRequest.dayToRegistry())
                .teamGroup(teamGroup)
                .build();

        registryWorkHoursRepository.save(registryWorkHours);

        user.setRegistryWorkHoursSet(Set.of(registryWorkHours));
        appUserRepository.save(user);
    }

    @Override
    public UserDto updateUser(UserDto updateUserRequest, Long id) {

        final AppUser user = appUserRepository.findById(id).orElseThrow(
                () -> new RestException(ExceptionEnum.USER_NOT_FOUND));

        user.setAge(updateUserRequest.age());
        user.setEmail(updateUserRequest.email());
        user.setFirstname(updateUserRequest.firstname());
        user.setLastname(updateUserRequest.lastname());
        user.setRole(updateUserRequest.role());
        user.setSex(updateUserRequest.sex());

        appUserRepository.save(user);

        return AppUserMapper.INSTANCE.userToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        AppUser user = AppUser.builder()
                .userCreated(LocalDate.now())
                .age(userDto.age())
                .password(userDto.password())
                .confirmationPassword(userDto.confirmationPassword())
                .email(userDto.email())
                .role(APP_USER)
                .sex(userDto.sex())
                .firstname(userDto.firstname())
                .lastname(userDto.lastname())
                .build();

        appUserRepository.save(user);

        return AppUserMapper.INSTANCE.userToUserDto(user);
    }
}
