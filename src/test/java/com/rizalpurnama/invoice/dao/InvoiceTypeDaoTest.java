package com.rizalpurnama.invoice.dao;

import com.rizalpurnama.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/sql/delete-invoice-type.sql", "/sql/insert-inactive-invoice-type.sql"})
public class InvoiceTypeDaoTest {

    @Autowired
    InvoiceTypeDao invoiceTypeDao;

    @Test
    void testIsnsertInvoiceType() throws InterruptedException {
        InvoiceType it = new InvoiceType();
        it.setCode("IT-001");
        it.setName("Test Input Invoice Type");

        Assertions.assertNull(it.getId());

        invoiceTypeDao.save(it);

        System.out.println("ID : " + it.getId());
        System.out.println("Created : " + it.getCreated());
        System.out.println("Created by : " + it.getCreatedBy());
        System.out.println("Updated : " + it.getUpdated());
        System.out.println("Updated by : " + it.getUpdatedBy());
        System.out.println("Status Record : " + it.getStatusRecord());

        Assertions.assertNotNull(it.getId());
        Assertions.assertNotNull(it.getCreated());
        Assertions.assertNotNull(it.getCreatedBy());
        Assertions.assertNotNull(it.getUpdated());
        Assertions.assertNotNull(it.getUpdatedBy());
        Assertions.assertEquals(it.getCreated(), it.getUpdated());

        Thread.sleep(2000);

        it.setName("test update");
        it = invoiceTypeDao.save(it);

        Assertions.assertNotEquals(it.getCreated(), it.getUpdated());
    }

    @Test
    void testSoftDelete() {
        long total = invoiceTypeDao.count();
        System.out.println("Total record sebelum didelete: " +total);
        Assertions.assertEquals(2, total);

        invoiceTypeDao.delete(invoiceTypeDao.findById("test02").get());
        total = invoiceTypeDao.count();
        System.out.println("Total record sesudahb didelete: " +total);
        Assertions.assertEquals(1, total);
    }
}
