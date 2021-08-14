package com.rizalpurnama.invoice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Data
public class Payment extends BaseEntity{

    @NotNull
    @ManyToOne @JoinColumn(name = "id_virtual_account")
    private VirtualAccount virtualAccount;

    @NotNull
    private LocalDateTime transactionTime;

    @NotNull
    private String providerRefference;

    @NotNull @Min(1)
    private BigDecimal amount;
}
