package com.fredrikpedersen.brewery.web.mappers;

import com.fredrikpedersen.brewery.domain.Beer;
import com.fredrikpedersen.brewery.domain.BeerOrder;
import com.fredrikpedersen.brewery.domain.BeerOrderLine;
import com.fredrikpedersen.brewery.web.model.BeerOrderDto;
import com.fredrikpedersen.brewery.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    default BeerOrderLine dtoToBeerOrder(BeerOrderLineDto dto){
        return BeerOrderLine.builder()
                .orderQuantity(dto.getOrderQuantity())
                .beer(Beer.builder().id(dto.getBeerId()).build())
                .build();
    }
}
