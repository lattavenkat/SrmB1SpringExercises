package com.org.spring.composite;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import com.org.spring.composite.model.MyAdmin;
import com.org.spring.composite.model.Product;
import com.org.spring.composite.model.ProductRequest;
import com.org.spring.composite.repository.AdminRepo;
import com.org.spring.composite.repository.ProductRepo;
import com.org.spring.composite.repository.ProductRequestRepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class CompositeApplication implements CommandLineRunner{
	private final ProductRepo prodRepo;
    private final AdminRepo adminRepo;
    private final ProductRequestRepo productrequestRepo;

	public static void main(String[] args) {
		SpringApplication.run(CompositeApplication.class, args);
	}
	@Override
    @Transactional
	public void run(String... strings) throws Exception {
     Product p1=new Product("Cheese");
	 Product p2=new Product("Milk");
	 prodRepo.saveAll(Arrays.asList(p1, p2));
	 MyAdmin a1 = new MyAdmin("Admin 1");
	 MyAdmin a2 = new MyAdmin("Admin 2");
	 adminRepo.saveAll(Arrays.asList(a1, a2));
	 ProductRequest pr1 = new ProductRequest(p1, a1, new Date());
	 ProductRequest pr2 = new ProductRequest(p1, a2, new Date());
	 ProductRequest pr3 = new ProductRequest(p2, a1, new Date());
	 ProductRequest pr4 = new ProductRequest(p2, a2, new Date());
	 productrequestRepo.saveAll(Arrays.asList(pr1, pr2, pr3, pr4));
 }
}
