package com.rizalpurnama.invoice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditLogService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String log){
        // Semua operasi yang ada di dalam sini akan dilakukan secara terpisah dari transaksi sebelumnya.
    }
}
