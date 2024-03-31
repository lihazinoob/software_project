package com.example.software_project;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.software_project.databinding.ActivityRegistrationPageBinding;

public class RegistrationPage extends AppCompatActivity {
    private ActivityRegistrationPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationPageBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        View root = binding.getRoot();
        setContentView(root);
    }
}