package doyun.lee.api.cart.controller;

import java.util.List;
import java.util.Optional;

import doyun.lee.api.cart.domain.Cart;
import doyun.lee.api.cart.service.CartServiceImpl;
import doyun.lee.api.cmm.controller.AbstractController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cart")
public class CartController extends AbstractController<Cart> {
	final CartServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody Cart t) {
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody Cart t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Cart> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Cart>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Cart>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
}