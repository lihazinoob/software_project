package com.example.software_project;

import static com.example.software_project.utils.Utils.uploadImageToFirebaseStorage;

import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.software_project.Models.UserModel;
import com.example.software_project.databinding.ActivityRegistrationPageBinding;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.software_project.utils.Utils;
public class RegistrationPage extends AppCompatActivity {
    private ActivityRegistrationPageBinding binding;
    private ActivityResultLauncher<Intent> imageUploadActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationPageBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        View root = binding.getRoot();
        setContentView(root);

        imageUploadActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Uri imageUri = data.getData();
                            // Use the imageUri as needed (e.g., display in ImageView)
                            UserModel.image = String.valueOf(uploadImageToFirebaseStorage(imageUri, "profile_images"));
                        }
                    }
                });




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
                            UserModel userModel = new UserModel(binding.usernameEditText.getText().toString(),binding.emailEditText.getText().toString(),binding.passwordEditText.getText().toString());
                            FirebaseFirestore.getInstance().collection("users").document(FirebaseAuth.getInstance().getUid()).set(userModel).addOnCompleteListener(task1 -> {
                                if(task1.isSuccessful())
                                {
                                    Toast.makeText(RegistrationPage.this, "User data saved to FireStore successfully", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(RegistrationPage.this,task1.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
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

        binding.addImage.setOnClickListener(
                v -> {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    imageUploadActivityResultLauncher.launch(intent);
                }
        );
    }
}