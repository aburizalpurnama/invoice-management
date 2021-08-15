package com.rizalpurnama.invoice.dao;

import com.rizalpurnama.invoice.entity.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentDao extends PagingAndSortingRepository<Payment, String>{
}
