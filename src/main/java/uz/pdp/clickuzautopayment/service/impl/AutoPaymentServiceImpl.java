package uz.pdp.clickuzautopayment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.clickuzautopayment.dto.PaymentDto;
import uz.pdp.clickuzautopayment.exception.NullOrEmptyException;
import uz.pdp.clickuzautopayment.model.AutoPayment;
import uz.pdp.clickuzautopayment.repository.AutoPaymentRepository;
import uz.pdp.clickuzautopayment.service.AutoPaymentService;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class AutoPaymentServiceImpl implements AutoPaymentService {
    private final AutoPaymentRepository autoPaymentRepository;
//    private final PaymentProxy paymentProxy;
    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10) ;
    @Override
    public void save(AutoPayment autoPayment) {
        if (autoPayment.getServiceId() == null)
            throw new NullOrEmptyException("Service ID");
        if (autoPayment.getAmount() == null)
            throw new NullOrEmptyException("Amount");
        if (autoPayment.getInitDateTime() == null)
            throw new NullOrEmptyException("Init Date");
        if (autoPayment.getPeriodDateTime() == null)
            throw new NullOrEmptyException("Period date time");
        if (autoPayment.getSenderCardNumber() == null
                || autoPayment.getSenderCardNumber().isEmpty()
                || autoPayment.getSenderCardNumber().isBlank())
            throw new NullOrEmptyException("Sender card number");
        autoPayment(autoPayment);
        autoPaymentRepository.save(autoPayment);
    }

    @Override
    public void update(AutoPayment autoPayment) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AutoPayment getById(Long id) {
        return null;
    }
    public void autoPayment(AutoPayment autoPayment){
        scheduledExecutorService.scheduleWithFixedDelay(
                ()->{
                    Map<String, Object> values = new HashMap<>();
                    autoPayment.getValues().forEach(v-> values.put(v.getKey(),v.getValue())
                    );
                    payment(new PaymentDto(autoPayment.getServiceId(),
                            autoPayment.getSenderCardNumber(),
                            values
                            ,autoPayment.getAmount()
                            ));
                },
                autoPayment.getInitDateTime(),
                autoPayment.getPeriodDateTime(),
                TimeUnit.MILLISECONDS
        );
    }
    public void payment(PaymentDto paymentDto){
        System.out.println(paymentDto.toString());
    }
}
