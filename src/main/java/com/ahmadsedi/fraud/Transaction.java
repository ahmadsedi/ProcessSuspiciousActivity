package com.ahmadsedi.fraud;

/**
 * @author Ahmad R. Seddighi (ahmadseddighi@yahoo.com)
 * Date: 08/11/2024
 * Time: 18:03
 */

public class Transaction {
    String senderId;
    String receiverId;
    Integer amount;

    public Transaction(String logRecord) {
        String[] parts = logRecord.split("\\s+");
        this.senderId = senderId = parts[0];
        this.receiverId = receiverId = parts[1];
        this.amount = Integer.parseInt(parts[2]);
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public Integer getAmount() {
        return amount;
    }
}