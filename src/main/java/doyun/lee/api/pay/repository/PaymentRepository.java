package doyun.lee.api.pay.repository;

import doyun.lee.api.pay.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentCustomRepository{
	
}
public interface PaymentRepository extends JpaRepository<Payment, Long>,
PaymentCustomRepository{

}