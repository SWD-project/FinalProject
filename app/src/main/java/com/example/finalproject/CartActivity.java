package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
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
import com.example.finalproject.model.dto.AddToCartRequest;
import com.example.finalproject.model.dto.AddToCartResponse;
import com.example.finalproject.model.dto.CartDetailResponse;
import com.example.finalproject.model.dto.CheckoutRequest;
import com.example.finalproject.model.dto.CheckoutResponse;
import com.example.finalproject.model.dto.GetCartResponse;
import com.example.finalproject.model.dto.ResponseBody;
import com.example.finalproject.model.entity.PaymentGateway;
import com.google.firebase.auth.FirebaseAuth;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
    private String uuid;

    public double total = 0;

    private List<CartDetailResponse> list;
    public List<String> listCartId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

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

        // uuid = FirebaseAuth.getInstance().getUid();
        uuid = "odRaAE9UPaTaXh5qRyzsenb4oqv1";
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

                try {
                    startVNPay();
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeyException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private void startVNPay() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String url = PaymentGateway.createPaymentUrl(total * 24500, "http://drawdemy");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);




        //checkout();
    }

    private void checkout() {
        Call<ResponseBody<CheckoutResponse>> call = cartService.checkout(uuid, new CheckoutRequest(listCartId, 2));
        call.enqueue(new Callback<ResponseBody<CheckoutResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<CheckoutResponse>> call, Response<ResponseBody<CheckoutResponse>> response) {
                displayToast("Checkout success!");
            }

            @Override
            public void onFailure(Call<ResponseBody<CheckoutResponse>> call, Throwable t) {
                displayToast("Checkout fail!");
            }
        });
    }

    private void getCart() {

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

    private void addToCart() {
        String courseId = "";
        Call<ResponseBody<AddToCartResponse>> call = cartService.AddToCart(uuid,new AddToCartRequest());
        call.enqueue(new Callback<ResponseBody<AddToCartResponse>>() {
            @Override
            public void onResponse(Call<ResponseBody<AddToCartResponse>> call, Response<ResponseBody<AddToCartResponse>> response) {
                displayToast("add to cart success");
            }

            @Override
            public void onFailure(Call<ResponseBody<AddToCartResponse>> call, Throwable t) {
                displayToast("add to cart fail");
            }
        });
    }


}