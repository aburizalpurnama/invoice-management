package com.rizalpurnama.invoice.service;

import com.rizalpurnama.invoice.entity.Invoice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class InvoiceService {

    public Invoice createInvoice(){
        Invoice invoice = new Invoice();

        return invoice;
    }
}
