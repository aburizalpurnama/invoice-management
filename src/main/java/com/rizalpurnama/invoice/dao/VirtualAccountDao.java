package com.rizalpurnama.invoice.dao;

import com.rizalpurnama.invoice.entity.PaymentProvider;
import com.rizalpurnama.invoice.entity.VirtualAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface VirtualAccountDao extends PagingAndSortingRepository<VirtualAccount, String> {

    Optional<VirtualAccount> findByPaymentProviderAndCompanyIdAndAccountNumber(PaymentProvider provider, String companyId, String accountNumber);
}
