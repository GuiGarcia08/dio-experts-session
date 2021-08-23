package one.digitalinnovation.experts.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import one.digitalinnovation.experts.shoppingcart.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer> {
	Cart findByCustomerId(Integer customerId);
}
