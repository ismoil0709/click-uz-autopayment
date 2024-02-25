package uz.pdp.clickuzautopayment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AutoPaymentValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;
    private String value;
    @ManyToOne
    @JoinColumn(name = "auto_payment_id")
    private AutoPayment autoPayment;
}
