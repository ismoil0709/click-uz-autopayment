package uz.pdp.clickuzautopayment.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.clickuzautopayment.dto.PaymentDto;

@FeignClient("hello")
public interface PaymentProxy {
    @PostMapping("")
    ResponseEntity<?> payment(PaymentDto paymentDto);
}
