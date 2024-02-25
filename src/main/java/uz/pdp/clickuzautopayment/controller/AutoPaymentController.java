package uz.pdp.clickuzautopayment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.clickuzautopayment.model.AutoPayment;
import uz.pdp.clickuzautopayment.service.AutoPaymentService;

@RestController
@RequestMapping("/auto/payment")
@RequiredArgsConstructor
public class AutoPaymentController {

    private final AutoPaymentService autoPaymentService;

    @PostMapping("/")
    public ResponseEntity<?> autoPayment(@RequestBody AutoPayment autoPayment){
        autoPaymentService.save(autoPayment);
        return ResponseEntity.ok("OK");
    }
}
