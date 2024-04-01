package com.example.software_project.utils;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class Utils {

    private static final String TAG = "Utils";

    // Method to upload image to Firebase Storage and return download URL
    public static Task<String> uploadImageToFirebaseStorage(Uri imageUri, String folderName) {
        // Create a unique filename for the image
        String filename = UUID.randomUUID().toString();
        // Get a reference to the Firebase Storage location
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child(folderName).child(filename);

        // Upload the image to Firebase Storage
        UploadTask uploadTask = storageRef.putFile(imageUri);

        // Task to get the download URL after the upload is complete
        Task<Uri> urlTask = uploadTask.continueWithTask(task -> {
            if (!task.isSuccessful()) {
                throw task.getException(); // Handle failures
            }

            // Continue with the task to get the download URL
            return storageRef.getDownloadUrl();
        });

        // Convert Task<Uri> to Task<String> representing the download URL
        return urlTask.continueWith(task -> {
            if (task.isSuccessful()) {
                Uri downloadUri = task.getResult(); // Get the download URL
                String downloadUrl = downloadUri.toString();
                Log.d(TAG, "Image uploaded successfully. Download URL: " + downloadUrl);
                return downloadUrl;
            } else {
                Log.e(TAG, "Image upload failed: ", task.getException());
                throw task.getException(); // Propagate the exception
            }
        });
    }
}