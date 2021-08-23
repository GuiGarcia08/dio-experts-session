package one.digitalinnovation.experts.productcatalog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.experts.productcatalog.model.Product;
import one.digitalinnovation.experts.productcatalog.repository.ProductRepository;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductRepository repository;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return repository.save(product);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Product> findyById(@PathVariable Integer id) {
		return repository.findById(id);
	}
}
