package user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void registryWorkHours(RegistryWorkHoursRequest reportWorkHoursRequest) {

    }
}
