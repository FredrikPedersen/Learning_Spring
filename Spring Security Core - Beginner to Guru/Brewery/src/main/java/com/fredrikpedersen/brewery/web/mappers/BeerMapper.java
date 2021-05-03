package com.fredrikpedersen.brewery.web.mappers;

import com.fredrikpedersen.brewery.web.model.BeerDto;
import com.fredrikpedersen.brewery.domain.Beer;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class, componentModel = "spring")
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
