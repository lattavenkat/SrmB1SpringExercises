package com.org.srm.manytomany;

import com.org.srm.manytomany.model.Employee;
import com.org.srm.manytomany.model.Project;
import com.org.srm.manytomany.repository.EmployeeRepository;
import com.org.srm.manytomany.repository.ProjectRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManytomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}
	@Bean
    public CommandLineRunner mappingDemo(EmployeeRepository employeeRepository,
                                         ProjectRepository projectRepository) {
        return args -> {


            Employee employee1 = new Employee(9,"LAVS");
            Employee employee2 = new Employee(999999992,"Shravs");
			Employee employee3 = new Employee(999999993,"Nithu");
            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
			employeeRepository.save(employee3);

            Project project1 = new Project(9999999999101,"Star Finance System",50000.00);
            Project project2 = new Project(9999999999102,"Inventory Management System",59000.00);

            projectRepository.saveAll(Arrays.asList(project1, project2));

            employee1.getCourses().addAll(Arrays.asList(project1, project2));
            employee2.getCourses().addAll(Arrays.asList(project1));
			employee3.getCourses().addAll(Arrays.asList(project2));

            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
			employeeRepository.save(employee3);
            System.out.println(employeeRepository.findByNameContaining("Shravs"));
        };
    }
}
