// Generated by view binder compiler. Do not edit!
package com.example.software_project.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.software_project.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegistrationPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CircleImageView addImage;

  @NonNull
  public final TextInputEditText emailEditText;

  @NonNull
  public final TextView loginPageLinkFromRegistration;

  @NonNull
  public final TextView loginTextPrompt;

  @NonNull
  public final TextInputLayout outlinedTextFieldemail;

  @NonNull
  public final TextInputLayout outlinedTextFieldpassword;

  @NonNull
  public final TextInputLayout outlinedTextFieldusername;

  @NonNull
  public final TextInputEditText passwordEditText;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final MaterialButton registrationButton;

  @NonNull
  public final TextInputEditText usernameEditText;

  private ActivityRegistrationPageBinding(@NonNull ConstraintLayout rootView,
      @NonNull CircleImageView addImage, @NonNull TextInputEditText emailEditText,
      @NonNull TextView loginPageLinkFromRegistration, @NonNull TextView loginTextPrompt,
      @NonNull TextInputLayout outlinedTextFieldemail,
      @NonNull TextInputLayout outlinedTextFieldpassword,
      @NonNull TextInputLayout outlinedTextFieldusername,
      @NonNull TextInputEditText passwordEditText, @NonNull CircleImageView profileImage,
      @NonNull MaterialButton registrationButton, @NonNull TextInputEditText usernameEditText) {
    this.rootView = rootView;
    this.addImage = addImage;
    this.emailEditText = emailEditText;
    this.loginPageLinkFromRegistration = loginPageLinkFromRegistration;
    this.loginTextPrompt = loginTextPrompt;
    this.outlinedTextFieldemail = outlinedTextFieldemail;
    this.outlinedTextFieldpassword = outlinedTextFieldpassword;
    this.outlinedTextFieldusername = outlinedTextFieldusername;
    this.passwordEditText = passwordEditText;
    this.profileImage = profileImage;
    this.registrationButton = registrationButton;
    this.usernameEditText = usernameEditText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegistrationPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegistrationPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_registration_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegistrationPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_image;
      CircleImageView addImage = ViewBindings.findChildViewById(rootView, id);
      if (addImage == null) {
        break missingId;
      }

      id = R.id.email_edit_text;
      TextInputEditText emailEditText = ViewBindings.findChildViewById(rootView, id);
      if (emailEditText == null) {
        break missingId;
      }

      id = R.id.login_page_link_from_registration;
      TextView loginPageLinkFromRegistration = ViewBindings.findChildViewById(rootView, id);
      if (loginPageLinkFromRegistration == null) {
        break missingId;
      }

      id = R.id.login_text_prompt;
      TextView loginTextPrompt = ViewBindings.findChildViewById(rootView, id);
      if (loginTextPrompt == null) {
        break missingId;
      }

      id = R.id.outlinedTextFieldemail;
      TextInputLayout outlinedTextFieldemail = ViewBindings.findChildViewById(rootView, id);
      if (outlinedTextFieldemail == null) {
        break missingId;
      }

      id = R.id.outlinedTextFieldpassword;
      TextInputLayout outlinedTextFieldpassword = ViewBindings.findChildViewById(rootView, id);
      if (outlinedTextFieldpassword == null) {
        break missingId;
      }

      id = R.id.outlinedTextFieldusername;
      TextInputLayout outlinedTextFieldusername = ViewBindings.findChildViewById(rootView, id);
      if (outlinedTextFieldusername == null) {
        break missingId;
      }

      id = R.id.password_edit_text;
      TextInputEditText passwordEditText = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.registration_button;
      MaterialButton registrationButton = ViewBindings.findChildViewById(rootView, id);
      if (registrationButton == null) {
        break missingId;
      }

      id = R.id.username_edit_text;
      TextInputEditText usernameEditText = ViewBindings.findChildViewById(rootView, id);
      if (usernameEditText == null) {
        break missingId;
      }

      return new ActivityRegistrationPageBinding((ConstraintLayout) rootView, addImage,
          emailEditText, loginPageLinkFromRegistration, loginTextPrompt, outlinedTextFieldemail,
          outlinedTextFieldpassword, outlinedTextFieldusername, passwordEditText, profileImage,
          registrationButton, usernameEditText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
