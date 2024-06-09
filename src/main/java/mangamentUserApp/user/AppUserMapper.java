package mangamentUserApp.user;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface AppUserMapper {

    AppUserMapper INSTANCE = Mappers.getMapper(AppUserMapper.class);

    UserDto userToUserDto(AppUser user);
}
