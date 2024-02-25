package uz.pdp.clickuzautopayment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class PaymentDto {
    private Long serviceId;
    private String senderCardNumber;
    private Map<String,Object> values;
    private BigDecimal amount;
}
