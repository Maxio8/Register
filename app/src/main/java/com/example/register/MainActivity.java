package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText EmailAddress, Password, Password_2;
    private TextView Title, tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EmailAddress = findViewById(R.id.EmailAddress);
        Password = findViewById(R.id.Password);
        Password_2 = findViewById(R.id.Password_2);
        tvMessage = findViewById(R.id.tvMessage);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // początkowy komunikat
        tvMessage.setText("Autor: Max Kuster");

        // Obsługa przycisku
        btnSubmit.setOnClickListener(v -> {
            String email = EmailAddress.getText().toString().trim();
            String password = Password.getText().toString();
            String password_2 = Password_2.getText().toString();


            // Sprawdzanie warunków
            if (TextUtils.isEmpty(email)) {
                tvMessage.setText("Proszę wprowadzić adres e-mail");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvMessage.setText("Nieprawidłowy adres email");
            } else if (TextUtils.isEmpty(password)) {
                tvMessage.setText("Proszę wprowadzić hasło");
            } else if (TextUtils.isEmpty(password_2)) {
                tvMessage.setText("Proszę powtórzyć hasło");
            } else if (!password.equals(password_2)) {
                tvMessage.setText("Hasła się różnią");
            } else {
                tvMessage.setText("Witaj " + email);
            }
        });
    }
}
