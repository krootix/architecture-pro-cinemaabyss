package ru.cinema.events.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.cinema.events.dto.PaymentDto;
import ru.cinema.events.event.PaymentEvent;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "paymentId", source = "id")
    PaymentEvent toEvent(PaymentDto dto);

}
