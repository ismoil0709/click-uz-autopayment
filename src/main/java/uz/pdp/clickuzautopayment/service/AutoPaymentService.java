package uz.pdp.clickuzautopayment.service;

import org.springframework.stereotype.Service;
import uz.pdp.clickuzautopayment.model.AutoPayment;
@Service
public interface AutoPaymentService {
    void save(AutoPayment autoPayment);
    void update(AutoPayment autoPayment);
    void delete(Long id);
    AutoPayment getById(Long id);
}