package com.example.Payroll;

import com.example.Payroll.Employee.Employee;
import com.example.Payroll.Employee.EmployeeRepository;
import com.example.Payroll.Enums.Status;
import com.example.Payroll.Order.Order;
import com.example.Payroll.Order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    public static final Logger logs =
            LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Jed", "Gray", "Software Developer"));
            employeeRepository.save(new Employee("Amy", "Gray", "Senior Exec Sec"));
            employeeRepository.save(new Employee("Andrew", "Gray", "Builder"));
            employeeRepository.save(new Employee("Tommy", "Fenegen", "Web developer"));
            employeeRepository.save(new Employee("James", "Stanton", "Reseacher"));

            orderRepository.save(new Order("ROG PC", Status.COMPLETED));
            orderRepository.save(new Order("Ipad", Status.IN_PROGRESS));
            orderRepository.save(new Order("TV", Status.IN_PROGRESS));
            orderRepository.save(new Order("Automatic cat feeder", Status.CANCELLED));
            orderRepository.save(new Order("Office Chair", Status.COMPLETED));


            orderRepository.findAll().forEach(order -> {
                logs.info("Preloaded " + order);
            });

            employeeRepository.findAll().forEach(person -> {
                logs.info("Preloaded " + person);
            });
        };
    }
}
