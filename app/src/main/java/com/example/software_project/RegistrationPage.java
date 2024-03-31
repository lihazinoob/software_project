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

import com.example.software_project.databinding.ActivityRegistrationPageBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity {
    private ActivityRegistrationPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationPageBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        View root = binding.getRoot();
        setContentView(root);

        binding.registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to register user

                if(binding.usernameEditText.getText().toString().isEmpty() || binding.passwordEditText.getText().toString().isEmpty() || binding.emailEditText.getText().toString().isEmpty())
                {
                    // Show error message
                    Toast.makeText(RegistrationPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Register user
                    // Code to register user
                    // Redirect to login page
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                            binding.emailEditText.getText().toString(),
                            binding.passwordEditText.getText().toString()
                    ).addOnCompleteListener(task -> {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RegistrationPage.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(RegistrationPage.this, LoginPage.class);
                            //startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RegistrationPage.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    //Toast.makeText(RegistrationPage.this, "User registered successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}