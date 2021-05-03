package com.fredrikpedersen.brewery.web.mappers;

import com.fredrikpedersen.brewery.domain.BeerOrderLine;
import com.fredrikpedersen.brewery.web.model.BeerOrderLineDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class}, componentModel = "spring")
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
