package com.fredrikpedersen.brewery.bootstrap;

import com.fredrikpedersen.brewery.domain.*;
import com.fredrikpedersen.brewery.domain.security.Authority;
import com.fredrikpedersen.brewery.domain.security.Role;
import com.fredrikpedersen.brewery.domain.security.User;
import com.fredrikpedersen.brewery.repositories.*;
import com.fredrikpedersen.brewery.repositories.security.AuthorityRepository;
import com.fredrikpedersen.brewery.repositories.security.RoleRepository;
import com.fredrikpedersen.brewery.repositories.security.UserRepository;
import com.fredrikpedersen.brewery.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.fredrikpedersen.brewery.security.permissions.Authorities.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    public static final String TASTING_ROOM = "Tasting Room";
    public static final String ST_PETE_DISTRIBUTING = "St Pete Distributing";
    public static final String DUNEDIN_DISTRIBUTING = "Dunedin Distributing";
    public static final String KEY_WEST_DISTRIBUTORS = "Key West Distributors";

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BreweryRepository breweryRepository;
    private final BeerRepository beerRepository;
    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerOrderRepository beerOrderRepository;
    private final CustomerRepository customerRepository;
    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedSecurityData();
        loadBreweryData();
        loadTastingRoomData();
        loadCustomers();
    }

    private void seedSecurityData() {
        log.info("Seeding user data...");

        //Beer authorities
        final Authority createBeer = authorityRepository.save(Authority.builder().permission(BEER_CREATE).build());
        final Authority updateBeer = authorityRepository.save(Authority.builder().permission(BEER_UPDATE).build());
        final Authority readBeer = authorityRepository.save(Authority.builder().permission(BEER_READ).build());
        final Authority deleteBeer = authorityRepository.save(Authority.builder().permission(BEER_DELETE).build());

        //Customer authorities
        final Authority createCustomer = authorityRepository.save(Authority.builder().permission(CUSTOMER_CREATE).build());
        final Authority readCustomer = authorityRepository.save(Authority.builder().permission(CUSTOMER_READ).build());
        final Authority updateCustomer = authorityRepository.save(Authority.builder().permission(CUSTOMER_UPDATE).build());
        final Authority deleteCustomer = authorityRepository.save(Authority.builder().permission(CUSTOMER_DELETE).build());

        //Brewery authorities
        final Authority createBrewery = authorityRepository.save(Authority.builder().permission(BREWERY_CREATE).build());
        final Authority readBrewery = authorityRepository.save(Authority.builder().permission(BREWERY_READ).build());
        final Authority updateBrewery = authorityRepository.save(Authority.builder().permission(BREWERY_UPDATE).build());
        final Authority deleteBrewery = authorityRepository.save(Authority.builder().permission(BREWERY_DELETE).build());

        //Beer Customer Orders authorities
        final Authority customerCreateOrder = authorityRepository.save(Authority.builder().permission(CUSTOMER_ORDER_CREATE).build());
        final Authority customerReadOrder = authorityRepository.save(Authority.builder().permission(CUSTOMER_ORDER_READ).build());
        final Authority customerUpdateOrder = authorityRepository.save(Authority.builder().permission(CUSTOMER_ORDER_UPDATE).build());
        final Authority customerDeleteOrder = authorityRepository.save(Authority.builder().permission(CUSTOMER_ORDER_DELETE).build());

        //Beer Admin Orders authorities
        final Authority adminCreateOrder = authorityRepository.save(Authority.builder().permission(ADMIN_ORDER_CREATE).build());
        final Authority adminReadOrder = authorityRepository.save(Authority.builder().permission(ADMIN_ORDER_READ).build());
        final Authority adminUpdateOrder = authorityRepository.save(Authority.builder().permission(ADMIN_ORDER_UPDATE).build());
        final Authority adminDeleteOrder = authorityRepository.save(Authority.builder().permission(ADMIN_ORDER_DELETE).build());

        //Roles
        final Role adminRole = roleRepository.save(Role.builder().name("ADMIN").build());
        final Role customerRole = roleRepository.save(Role.builder().name("CUSTOMER").build());
        final Role userRole = roleRepository.save(Role.builder().name("USER").build());

        adminRole.setAuthorities(new HashSet<>(Set.of(createBeer, updateBeer, readBeer, deleteBeer, createCustomer, readCustomer, updateCustomer, deleteCustomer, createBrewery, readBrewery, updateBrewery, deleteBrewery, adminCreateOrder, adminReadOrder, adminUpdateOrder, adminDeleteOrder)));
        customerRole.setAuthorities(new HashSet<>(Set.of(readBeer, readCustomer, readBrewery, customerCreateOrder, customerReadOrder, customerUpdateOrder, customerDeleteOrder)));
        userRole.setAuthorities(new HashSet<>(Set.of(readBeer)));

        roleRepository.saveAll(Arrays.asList(adminRole, customerRole, userRole));

        userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .role(adminRole)
                .build());

        userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .role(userRole)
                .build());

        userRepository.save(User.builder()
                .username("customer")
                .password(passwordEncoder.encode("password"))
                .role(customerRole)
                .build());

        log.info("Done seeding user data!");
    }

    private void loadBreweryData() {
        if (breweryRepository.count() == 0) {
            breweryRepository.save(Brewery
                    .builder()
                    .breweryName("Cage Brewing")
                    .build());

            Beer mangoBobs = Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_1_UPC)
                    .build();

            beerRepository.save(mangoBobs);
            beerInventoryRepository.save(BeerInventory.builder()
                    .beer(mangoBobs)
                    .quantityOnHand(500)
                    .build());

            Beer galaxyCat = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .build();

            beerRepository.save(galaxyCat);
            beerInventoryRepository.save(BeerInventory.builder()
                    .beer(galaxyCat)
                    .quantityOnHand(500)
                    .build());

            Beer pinball = Beer.builder()
                    .beerName("Pinball Porter")
                    .beerStyle(BeerStyleEnum.PORTER)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_3_UPC)
                    .build();

            beerRepository.save(pinball);
            beerInventoryRepository.save(BeerInventory.builder()
                    .beer(pinball)
                    .quantityOnHand(500)
                    .build());

        }
    }

    private void loadTastingRoomData() {
        Customer tastingRoom = Customer.builder()
                .customerName(TASTING_ROOM)
                .apiKey(UUID.randomUUID())
                .build();

        customerRepository.save(tastingRoom);

        beerRepository.findAll().forEach(beer -> {
            beerOrderRepository.save(BeerOrder.builder()
                    .customer(tastingRoom)
                    .orderStatus(OrderStatusEnum.NEW)
                    .beerOrderLines(Set.of(BeerOrderLine.builder()
                            .beer(beer)
                            .orderQuantity(2)
                            .build()))
                    .build());
        });
    }

    private void loadCustomers() throws NoSuchElementException {
        final Role customerRole = roleRepository.findByName("CUSTOMER").orElseThrow();

        //create customers
        final Customer stPeteCustomer = customerRepository.save(Customer.builder()
                .customerName(ST_PETE_DISTRIBUTING)
                .apiKey(UUID.randomUUID())
                .build());

        final Customer dunedinCustomer = customerRepository.save(Customer.builder()
                .customerName(DUNEDIN_DISTRIBUTING)
                .apiKey(UUID.randomUUID())
                .build());

        final Customer keyWestCustomer = customerRepository.save(Customer.builder()
                .customerName(KEY_WEST_DISTRIBUTORS)
                .apiKey(UUID.randomUUID())
                .build());

        //create users
        final User stPeteUser = userRepository.save(User.builder().username("stpete")
                .password(passwordEncoder.encode("password"))
                .customer(stPeteCustomer)
                .role(customerRole).build());

        final User dunedinUser = userRepository.save(User.builder().username("dunedin")
                .password(passwordEncoder.encode("password"))
                .customer(dunedinCustomer)
                .role(customerRole).build());

        final User keywest = userRepository.save(User.builder().username("keywest")
                .password(passwordEncoder.encode("password"))
                .customer(keyWestCustomer)
                .role(customerRole).build());

        //create orders
        createOrder(stPeteCustomer);
        createOrder(dunedinCustomer);
        createOrder(keyWestCustomer);

        log.info("Orders Loaded: " + beerOrderRepository.count());
    }

    private BeerOrder createOrder(final Customer customer) {
        return beerOrderRepository.save(BeerOrder.builder()
                .customer(customer)
                .orderStatus(OrderStatusEnum.NEW)
                .beerOrderLines(Set.of(BeerOrderLine.builder()
                        .beer(beerRepository.findByUpc(BEER_1_UPC))
                        .orderQuantity(2)
                        .build()))
                .build());
    }

}
