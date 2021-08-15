package com.rizalpurnama.invoice.helper;

import com.rizalpurnama.invoice.dao.VirtualAccountDao;
import com.rizalpurnama.invoice.entity.PaymentProvider;
import com.rizalpurnama.invoice.entity.VirtualAccount;
import com.rizalpurnama.invoice.exception.VirtualAccountNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class VirtualAccountHelper {

    public static VirtualAccount cekVaAda(VirtualAccountDao virtualAccountDao,
                                          PaymentProvider provider,
                                          String companyId,
                                          String accountNumber)
            throws VirtualAccountNotFountException {
        Optional<VirtualAccount> optVa =
                virtualAccountDao.findByPaymentProviderAndCompanyIdAndAccountNumber(
                        provider, companyId, accountNumber
                );
        if (!optVa.isPresent()){
            throw new VirtualAccountNotFountException("VA ["+ companyId +
                    "/"+ accountNumber +"-"+ provider.getCode()+"] not found.");
        }

        VirtualAccount va = optVa.get();
        return va;
    }
}
