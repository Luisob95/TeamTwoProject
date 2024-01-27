package com.example.myapplication.activity.login;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.UserManager;
public class Login_Register_Act extends AppCompatActivity {       //NOTE: ALSO DONT KNOW WHAT WE ARE TRAKING ABO FROM USER MAY NEED TO ADD EMAIL textEdit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.login_register_layout);
        // Initialization
        Button signupBtn = findViewById(R.id.btnSignUp_Reg);
        TextView backBtn = findViewById(R.id.btnBack_Reg);
        EditText usernameEditText = findViewById(R.id.username_Reg_EditText);
        EditText usernameConEditText = findViewById(R.id.username_Reg_Con_EditText);
        EditText passwordEditText = findViewById(R.id.password_Reg_EditText);
        EditText passwordConEditText = findViewById(R.id.password_Reg_ConEditText);
        // Button Listeners
        // Signup
        signupBtn.setOnClickListener(v -> {
                if(usernameConEditText.getText() == usernameEditText.getText() && passwordConEditText.getText() == passwordEditText.getText()){
                    // If Usernames && Passwords  Match Return to Login Menu
                    Intent intent = new Intent(Login_Register_Act.this, Login_Menu_Act.class);
                    startActivity(intent);
                }
                // If Fail
        });
        // Back
        backBtn.setOnClickListener(v->{
            // Returns to Login Menu
            Intent intent = new Intent(Login_Register_Act.this, Login_Menu_Act.class);
            startActivity(intent);
        });
    }
}


