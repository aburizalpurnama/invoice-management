package com.rizalpurnama.invoice.service;

import com.rizalpurnama.invoice.exception.VirtualAccountAlreadyPaidException;
import com.rizalpurnama.invoice.exception.VirtualAccountNotFountException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    void testPay() throws VirtualAccountNotFountException, VirtualAccountAlreadyPaidException {
        paymentService.pay(null,
                null,
                null,
                null,
                null);
    }
}
