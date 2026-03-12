package ru.cinema.events.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cinema.events.dto.MovieDto;
import ru.cinema.events.event.MovieEvent;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "movieId", source = "id")
    MovieEvent toEvent(MovieDto dto);

}
