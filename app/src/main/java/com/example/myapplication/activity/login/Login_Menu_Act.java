package com.example.myapplication.activity.login;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.Settings;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Login_Menu_Act extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.login_layout);
        // Initializer
        Button loginBtn = findViewById(R.id.btnLogin);
        EditText usernameEditText = findViewById(R.id.username_EditText);
        EditText passwordEditText = findViewById(R.id.password_EditText);
        TextView signupButton = findViewById(R.id.btnSignUp);
        ProgressBar progressBar = findViewById(R.id.progressbar);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        getSupportActionBar().hide();
        // Button Listeners
        // Login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set visibility of progressbar
                progressBar.setVisibility(View.VISIBLE);

                // Get field values
                String username, usernameConfirm,  password, passwordConfirm;
                username = String.valueOf(usernameEditText.getText());
                password = String.valueOf((passwordEditText.getText()));

                // Check if fields are empty
                if (TextUtils.isEmpty((username)) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Login_Menu_Act.this,"username or password is incorrect", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Try to login the user
                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login_Menu_Act.this, "Login successful.",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    Settings.setLoggedIn(true);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login_Menu_Act.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
        // Signup
        signupButton.setOnClickListener(v->{
            // Change Activity to Login Register
            Intent intent = new Intent(Login_Menu_Act.this, Login_Register_Act.class);
            startActivity(intent);
        });
    }
}

