package com.rizalpurnama.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RunningNumberTest {

    @Autowired
    RunningNumberService runningNumberService;

    @Test
    void testGetNumber() throws InterruptedException {
        int jumlahThread = 10;
        int iterasi = 5;

        for (int i = 0; i < jumlahThread; i++) {
            int x = i;
            new Thread(() -> {
                for (int j = 0; j < iterasi; j++) {
                    Long number = runningNumberService.getNumber("Test");
                    Assertions.assertNotNull(number);
                    System.out.println("Thread "+ x +": " + number);
                }
            }).run();
        }

        Thread.sleep(10 * 1000);
    }
}
