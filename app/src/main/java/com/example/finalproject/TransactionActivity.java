package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.R;
import com.example.finalproject.adapter.TransactionAdapter;
import com.example.finalproject.api.transaction.TransactionRepository;
import com.example.finalproject.api.transaction.TransactionService;
import com.example.finalproject.model.dto.GetCourseResponse;
import com.example.finalproject.model.dto.GetTransactionRequest;
import com.example.finalproject.model.dto.GetTransactionRespone;
import com.example.finalproject.model.dto.ResponseBody;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class TransactionActivity extends AppCompatActivity {


    TransactionService transactionService;
    ListView listView;
    List<GetTransactionRespone> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        map();


        Call<ResponseBody<GetTransactionRespone>> call = transactionService.getTransaction("odRaAE9UPaTaXh5qRyzsenb4oqv1");
        call.enqueue(new Callback<ResponseBody<GetTransactionRespone>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetTransactionRespone>> call, Response<ResponseBody<GetTransactionRespone>> response) {
                ResponseBody<GetTransactionRespone> x = response.body();
                list = x.getData();
                if(list == null || list.size() == 0){
                    displayToast("list is null");
                }
                displayToast(list.get(0).getCourseId().getTitle());
                adapter();
            }

            @Override
            public void onFailure(Call<ResponseBody<GetTransactionRespone>> call, Throwable t) {

            }
        });

    }
    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void map(){
        transactionService = TransactionRepository.getTracsactionService();
        listView = findViewById(R.id.list_transaction);
    }
    private void adapter(){
        TransactionAdapter adapter = new TransactionAdapter(this,R.layout.activity_transaction_item,list);
        listView.setAdapter(adapter);
    }
}