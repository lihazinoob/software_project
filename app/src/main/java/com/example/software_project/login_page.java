package com.example.software_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.software_project.Models.UserModel;
import com.example.software_project.databinding.ActivityLoginPageBinding;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class login_page extends AppCompatActivity {
    private ActivityLoginPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        binding.registrationPageLinkFromLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_page.this, RegistrationPage.class));
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to login user\
                if(binding.emailEditText.getText().toString().isEmpty() || binding.passwordEditText.getText().toString().isEmpty())
                {
                    Toast.makeText(login_page.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    UserModel user = new UserModel(binding.emailEditText.getText().toString(), binding.passwordEditText.getText().toString());
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener(task -> {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(login_page.this, "Login successful", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(login_page.this, SplashScreen.class));
                        }
                        else
                        {
                            Toast.makeText(login_page.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}