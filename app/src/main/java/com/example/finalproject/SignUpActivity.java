package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.api.Api;
import com.example.finalproject.model.UserRegistrationRequest;
import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    TextView tvSignIn;
    EditText etEmail, etPassword, etConfirmPassword, etFirstName, etLastName;
    Button btnSignUp;

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bind();
        tvSignIn.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            finish();
        });

        btnSignUp.setOnClickListener(view -> {
            String firstName = etFirstName.getText().toString();
            String lastName = etLastName.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (!passwordsMatch(password, confirmPassword)) {
                displayToast("Passwords do not match");
                return;
            }

            mFirebaseAuth = FirebaseAuth.getInstance();
            createUserInFirebase(email, password, firstName, lastName);
        });
    }

    private boolean passwordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void createUserInFirebase(String email, String password, String firstName, String lastName) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                var user = task.getResult().getUser();
                String uuid = user.getUid();
                UserRegistrationRequest registrationRequest = new UserRegistrationRequest(firstName, lastName, "0", email, uuid);
                registerUserOnServer(registrationRequest);
            } else {
                displayFirebaseError(task.getException());
            }
        });
    }

    private void registerUserOnServer(UserRegistrationRequest registrationRequest) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<UserRegistrationRequest> call = api.createUser(registrationRequest);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<UserRegistrationRequest> call, Response<UserRegistrationRequest> response) {
                if (response.isSuccessful()) {
                    displayToast("Registration Successfully");
                    navigateToSignInActivity();
                } else {
                    displayToast("Registration Failed: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserRegistrationRequest> call, Throwable t) {
                displayToast("Error: " + t.getMessage());
            }
        });
    }

    private void displayFirebaseError(Exception exception) {
        String errorMessage = exception != null ? exception.getMessage() : "Unknown error";
        displayToast("Registration Failed: " + errorMessage);
    }

    private void navigateToSignInActivity() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

    private void bind() {
        tvSignIn = findViewById(R.id.tvSignIn);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

}