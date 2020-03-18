package com.fredrikpedersen.brewery.web.mappers;

import com.fredrikpedersen.brewery.domain.Beer;
import com.fredrikpedersen.brewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
