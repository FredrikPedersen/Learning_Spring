package com.fredrikpedersen.brewery.web.controllers.api;

import com.fredrikpedersen.brewery.security.permissions.AdminAndCustomerReadPermission;
import com.fredrikpedersen.brewery.services.BeerOrderService;
import com.fredrikpedersen.brewery.web.model.BeerOrderDto;
import com.fredrikpedersen.brewery.web.model.BeerOrderPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 10/08/2021 at 08:26
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers/{customerId}/")
public class BeerOrderController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerOrderService beerOrderService;

    @AdminAndCustomerReadPermission
    @GetMapping("orders")
    public BeerOrderPagedList listOrders(@PathVariable("customerId") final UUID customerId,
                                         @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                         @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        return beerOrderService.listOrders(customerId, PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("orders")
    @ResponseStatus(HttpStatus.CREATED)
    public BeerOrderDto placeOrder(@PathVariable("customerId") final UUID customerId, @RequestBody final BeerOrderDto beerOrderDto) {
        return beerOrderService.placeOrder(customerId, beerOrderDto);
    }

    @AdminAndCustomerReadPermission
    @GetMapping("orders/{orderId}")
    public BeerOrderDto getOrder(@PathVariable("customerId") final UUID customerId, @PathVariable("orderId") final UUID orderId) {
        return beerOrderService.getOrderById(customerId, orderId);
    }

    @PutMapping("/orders/{orderId}/pickup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pickupOrder(@PathVariable("customerId") final UUID customerId, @PathVariable("orderId") final UUID orderId) {
        beerOrderService.pickupOrder(customerId, orderId);
    }
}
