package ru.cinema.events.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cinema.events.dto.UserDto;
import ru.cinema.events.event.UserEvent;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    UserEvent toEvent(UserDto dto);

}
