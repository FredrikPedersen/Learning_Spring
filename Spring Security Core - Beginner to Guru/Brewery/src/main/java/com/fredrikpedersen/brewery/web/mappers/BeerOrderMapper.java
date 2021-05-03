package com.fredrikpedersen.brewery.web.mappers;

import com.fredrikpedersen.brewery.domain.BeerOrder;
import com.fredrikpedersen.brewery.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class}, componentModel = "spring")
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
