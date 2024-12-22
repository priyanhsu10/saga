package pro.com.payment_ms.Dtos;

import lombok.Data;
import pro.com.payment_ms.entities.Payment;

@Data
public class PaymentDto {

    private long orderId;

    private Double amount;
    private String paymentStatus;
    private String transactionId;
    private String paymentMode;
    public static Payment getPaymentFrom(PaymentDto paymentDto){

        var payemnt= new Payment();
        payemnt.setAmount(paymentDto.getAmount());
        payemnt.setPaymentMode(paymentDto.getPaymentMode());
        payemnt.setPaymentStatus(paymentDto.getPaymentStatus());
        payemnt.setOrderId(paymentDto.getOrderId());
        payemnt.setTransactionId(paymentDto.getTransactionId());
        return payemnt;
    }


    public static PaymentDto getPaymentDtoFrom(Payment payment){

        var paymentDto = new PaymentDto();
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentMode(payment.getPaymentMode());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());
        paymentDto.setOrderId(payment.getOrderId());
        return paymentDto;
    }
}
