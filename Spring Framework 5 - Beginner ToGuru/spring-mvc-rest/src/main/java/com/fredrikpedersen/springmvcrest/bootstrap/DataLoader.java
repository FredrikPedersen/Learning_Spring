package com.fredrikpedersen.springmvcrest.bootstrap;

import com.fredrikpedersen.springmvcrest.domain.Category;
import com.fredrikpedersen.springmvcrest.domain.Customer;
import com.fredrikpedersen.springmvcrest.repositories.CategoryRepository;
import com.fredrikpedersen.springmvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 16/02/2020 at 16:32
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public DataLoader(final CategoryRepository categoryRepository, final CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createCategoryData();
        createCustomerData();
    }

    private void createCategoryData() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Category Records created = " + categoryRepository.count());
    }

    private void createCustomerData() {
        Customer fredrik = new Customer();
        fredrik.setId(1L);
        fredrik.setFirstName("Fredrik");
        fredrik.setLastName("Pedersen");

        Customer nikita = new Customer();
        nikita.setId(2L);
        nikita.setFirstName("Nikita");
        nikita.setLastName("Petrovs");

        Customer victor = new Customer();
        victor.setId(3L);
        victor.setFirstName("Victor");
        victor.setLastName("Pishva");

        Customer cato = new Customer();
        cato.setId(4L);
        cato.setFirstName("Cato");
        cato.setLastName("Akay");

        customerRepository.save(fredrik);
        customerRepository.save(nikita);
        customerRepository.save(victor);
        customerRepository.save(cato);

        System.out.println("Customer Records created = " + customerRepository.count());
    }
}
