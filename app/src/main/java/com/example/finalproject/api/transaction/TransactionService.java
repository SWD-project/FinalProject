package com.example.finalproject.api.transaction;
import com.example.finalproject.model.dto.GetTransactionRequest;
import com.example.finalproject.model.dto.GetTransactionRespone;
import com.example.finalproject.model.dto.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface TransactionService {
    @POST("transaction/get")
    Call<ResponseBody<GetTransactionRespone>> getTransaction(@Header("Authorization") String uuid, @Body GetTransactionRequest getTransactionRequest);

}
