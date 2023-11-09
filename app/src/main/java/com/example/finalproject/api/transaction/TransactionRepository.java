package com.example.finalproject.api.transaction;

import com.example.finalproject.api.APIClient;


public class TransactionRepository {
    public static TransactionService getTracsactionService(){
        return APIClient.getClient().create(TransactionService.class);
    }
}
