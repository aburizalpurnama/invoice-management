package com.rizalpurnama.invoice.exception;

public class VirtualAccountAlreadyPaidException extends Exception{
    public VirtualAccountAlreadyPaidException() {
    }

    public VirtualAccountAlreadyPaidException(String message) {
        super(message);
    }
}
