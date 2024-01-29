package com.example.myapplication.activity.login;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.activity.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.UserManager;

public class Login_Menu_Act extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.login_menu_layout);
        // Initializer
        Button loginBtn = findViewById(R.id.btnLogin);
        EditText usernameEditText = findViewById(R.id.username_EditText);
        EditText passwordEditText = findViewById(R.id.password_EditText);
        TextView signupButton = findViewById(R.id.btnSignUp);
        // Button Listeners
        // Login
        loginBtn.setOnClickListener(v -> {
            // Temporary Login Check
            if ("admin".equals(usernameEditText.getText().toString())
                && "admin".equals(passwordEditText.getText().toString())) {
                // Toggle UserLogIn Value
                UserManager.setUserLoggedIn(true);
                // Change Activity to Main
                 Intent intent = new Intent(Login_Menu_Act.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // Signup
        signupButton.setOnClickListener(v->{                                   //NOTE: I COULD MAKE THE REGISTER SCREEN A FRAGMENT OR A POP UP BUT NOT SURE YET
            // Change Activity to Login Register
            Intent intent = new Intent(Login_Menu_Act.this, Login_Register_Act.class);
            startActivity(intent);
        });



        // Help
        // Logic Here Im not sure if this is handled by firebase but im
        // thinking its just a pop up with an edit text input
        // For email input to search for password
    }
}

