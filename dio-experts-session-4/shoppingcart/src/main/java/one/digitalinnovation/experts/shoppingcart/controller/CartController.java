package one.digitalinnovation.experts.shoppingcart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.experts.shoppingcart.model.Cart;
import one.digitalinnovation.experts.shoppingcart.model.Item;
import one.digitalinnovation.experts.shoppingcart.repository.CartRepository;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

	 @Autowired
	    private CartRepository repository;

	    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
	    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
	        Optional<Cart> savedCart = repository.findById(id);
	        Cart cart;
	        if (savedCart.equals(Optional.empty())) {
	            cart = new Cart(id);
	        }
	        else {
	            cart = savedCart.get();
	        }
	        cart.getItems().add(item);
	        return repository.save(cart);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public Optional<Cart> findById(@PathVariable("id") Integer id) {
	        return repository.findById(id);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	    public void clear(@PathVariable("id") Integer id) {
	        repository.deleteById(id);
	    }

}
