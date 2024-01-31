package com.example.myapplication.activity.login;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Register_Act extends AppCompatActivity {       //NOTE: ALSO DONT KNOW WHAT WE ARE TRAKING ABO FROM USER MAY NEED TO ADD EMAIL textEdit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.login_register_layout);
        // Initialization
        Button signupBtn = findViewById(R.id.btnSignUp_Reg);
        TextView loginBtn = findViewById(R.id.loginbtn);
        EditText usernameEditText = findViewById(R.id.username_Reg_EditText);
        EditText usernameConEditText = findViewById(R.id.username_Reg_Con_EditText);
        EditText passwordEditText = findViewById(R.id.password_Reg_EditText);
        EditText passwordConEditText = findViewById(R.id.password_Reg_ConEditText);

        ProgressBar progressBar = findViewById(R.id.progressbar);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        // Button Listeners

        // Signup
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set visibility of progressbar
                progressBar.setVisibility(View.VISIBLE);

                // Get field values
                String username, usernameConfirm,  password, passwordConfirm;
                username = String.valueOf(usernameEditText.getText());
                usernameConfirm = String.valueOf((usernameConEditText.getText()));
                password = String.valueOf((passwordEditText.getText()));
                passwordConfirm = String.valueOf((passwordConEditText.getText()));

                // Check if fields are empty
                if (TextUtils.isEmpty((username)) || TextUtils.isEmpty(usernameConfirm) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordConfirm)) {
                    Toast.makeText(Login_Register_Act.this,"Fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check to see if the username and password match their confirm values
                if (!username.equals(usernameConfirm) ||
                        !password.equals(passwordConfirm)) {
                    Toast.makeText(Login_Register_Act.this, "Fields don't match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create user account
                mAuth.createUserWithEmailAndPassword(username, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE); // Set progressbar to gone
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login_Register_Act.this, "Account created!.",
                                            Toast.LENGTH_SHORT).show();

                                    FirebaseUser user = mAuth.getCurrentUser();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login_Register_Act.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        // Login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_Menu_Act.class);
                startActivity(intent);
                finish();
            }
        });

    }
}


