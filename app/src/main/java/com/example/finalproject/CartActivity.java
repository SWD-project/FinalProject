package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.adapter.CartAdapter;
import com.example.finalproject.api.cart.CartRepository;
import com.example.finalproject.api.cart.CartService;
import com.example.finalproject.model.dto.CartDetailResponse;
import com.example.finalproject.model.dto.GetCartResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    private CartService cartService;
    private Button btnCheckout;
    public TextView tv_total;
    private ListView lv;
    private CheckBox cbVnPay;

    public double total = 0;

    private List<CartDetailResponse> list;
    public List<String> listCartId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setup();
    }

    private void setup() {
        mapping();
        getCart();
        events();
    }

    private void mapping() {
        cartService = CartRepository.getCourseService();
        list = new ArrayList<>();
        listCartId = new ArrayList<>();

        btnCheckout = findViewById(R.id.btn_pay);
        tv_total = findViewById(R.id.tv_totalPrice);
        lv = findViewById(R.id.lv_cart);
        cbVnPay = findViewById(R.id.cb_vn_pay);
    }

    private void adapter() {
        CartAdapter cartAdapter = new CartAdapter(this, R.layout.cart_item, list);
        lv.setAdapter(cartAdapter);
    }

    private void events() {
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listCartId.isEmpty()) {
                    displayToast("Please choose item to payment!");
                    return;
                }
                if (!cbVnPay.isChecked()) {
                    displayToast("Please choose payment!");
                    return;
                }

                startVNPay();
            }
        });

    }

    private void startVNPay() {

    }

    private void getCart() {
        //String uuid = FirebaseAuth.getInstance().getUid();
        String uuid = "odRaAE9UPaTaXh5qRyzsenb4oqv1";

        Call<ResponseBody<GetCartResponse>> call = cartService.getCart(uuid);
        call.enqueue(new Callback<ResponseBody<GetCartResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<GetCartResponse>> call, Response<ResponseBody<GetCartResponse>> response) {
                ResponseBody<GetCartResponse> res = response.body();

                if (res == null) {
                    displayToast("response is null");
                    return;
                }
               list =  res.getData().get(0).getCartDetailList();
                if (list == null || list.size() == 0) {
                    displayToast("list is null");
                }

                adapter();
            }

            @Override
            public void onFailure(Call<ResponseBody<GetCartResponse>> call, Throwable t) {

            }
        });


    }
    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void updateTotal() {
        if (total < 0) {
            total = 0;
        }
        tv_total.setText("$" + String.valueOf(total));
    }


}