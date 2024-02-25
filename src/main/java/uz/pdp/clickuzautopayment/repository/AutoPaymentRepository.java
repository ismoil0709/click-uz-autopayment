package uz.pdp.clickuzautopayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.clickuzautopayment.model.AutoPayment;

@Repository
public interface AutoPaymentRepository extends JpaRepository<AutoPayment,Long> {
}
