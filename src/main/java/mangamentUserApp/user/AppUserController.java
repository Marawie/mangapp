package mangamentUserApp.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasRole('APP_USER')")
public class AppUserController {

    private final AppUserService appUserService;


    @PostMapping("/create-work-hours/{id}")
    public void create(@RequestBody RegistryWorkHoursRequest request,
                       @RequestBody TaskIdentityRequest taskIdentityRequest,
                       @RequestBody TeamGroupRequest teamGroupRequest,
                       @RequestBody TypeWorkRequest typeWorkRequest,
                       @PathVariable Long id){
        appUserService.registryWorkHours(request, typeWorkRequest , taskIdentityRequest , teamGroupRequest, id);
    }


    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto){
        return appUserService.createUser(userDto);
    }
}
