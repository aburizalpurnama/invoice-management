package com.rizalpurnama.invoice.service;

import com.rizalpurnama.invoice.dao.VirtualAccountDao;
import com.rizalpurnama.invoice.entity.PaymentProvider;
import com.rizalpurnama.invoice.entity.VirtualAccount;
import com.rizalpurnama.invoice.exception.VirtualAccountAlreadyPaidException;
import com.rizalpurnama.invoice.exception.VirtualAccountNotFountException;
import com.rizalpurnama.invoice.helper.VirtualAccountHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service @Transactional
public class PaymentService {

    @Autowired
    private VirtualAccountDao virtualAccountDao;

    @Autowired
    private AuditLogService auditLogService;

    public void pay(PaymentProvider provider,
                    String companyId, String accountNumber,
                    BigDecimal amount, String refference)
            throws VirtualAccountNotFountException, VirtualAccountAlreadyPaidException {

        // Proses bisnis :

        VirtualAccount va = VirtualAccountHelper.cekVaAda(virtualAccountDao, provider, companyId, accountNumber);
        auditLogService.log("Virtual Account : " + va);

        cekVaLunas(provider, companyId, accountNumber, va);
        auditLogService.log("Cek Lunas");

        // 3. Cek apakah amount > total tagihan ?
        // 4. Update status Virtual Account jadi lunas
        // 5. Update status invoice menjadi lunas
        // 6. insert ke table payment
        // 7. notifikasi (next phase)

    }

    private void cekVaLunas(PaymentProvider provider, String companyId, String accountNumber, VirtualAccount va) throws VirtualAccountAlreadyPaidException {
        if (va.getInvoice().isPaid()){
            throw new VirtualAccountAlreadyPaidException("VA ["+ companyId +
                    "/"+ accountNumber +"-"+ provider.getCode()+"] already paid.");
        }
    }


}
