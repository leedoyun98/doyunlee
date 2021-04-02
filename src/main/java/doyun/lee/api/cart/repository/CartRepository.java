package doyun.lee.api.cart.repository;

import doyun.lee.api.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


interface ICartRepository{
	
}
public interface CartRepository extends JpaRepository<Cart, Long>,
											ICartRepository{

}