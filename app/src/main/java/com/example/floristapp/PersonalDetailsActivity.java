package com.example.floristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonalDetailsActivity extends AppCompatActivity {

    private EditText nameEt, phoneEt, emailEt, addressEt;
    private RadioGroup addressTypeGroup;
    private Button nextBtn, backBtn;

    private int roses, lilies, tulips, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        emailEt = findViewById(R.id.emailEt);
        addressEt = findViewById(R.id.addressEt);
        addressTypeGroup = findViewById(R.id.addressTypeGroup);
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);

        roses = getIntent().getIntExtra("roses", 0);
        lilies = getIntent().getIntExtra("lilies", 0);
        tulips = getIntent().getIntExtra("tulips", 0);
        total = getIntent().getIntExtra("total", 0);

        backBtn.setOnClickListener(v -> finish());

        nextBtn.setOnClickListener(v -> {
            String name = nameEt.getText().toString().trim();
            String phone = phoneEt.getText().toString().trim();
            String email = emailEt.getText().toString().trim();
            String address = addressEt.getText().toString().trim();

            int selectedId = addressTypeGroup.getCheckedRadioButtonId();
            String addressType = "";

            if (selectedId != -1) {
                RadioButton selectedRadio = findViewById(selectedId);
                addressType = selectedRadio.getText().toString();
            }

            if (name.isEmpty()) {
                nameEt.setError("Enter name");
                nameEt.requestFocus();
                return;
            }

            if (phone.isEmpty()) {
                phoneEt.setError("Enter phone number");
                phoneEt.requestFocus();
                return;
            }

            if (phone.length() < 10) {
                phoneEt.setError("Enter valid phone number");
                phoneEt.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                emailEt.setError("Enter email");
                emailEt.requestFocus();
                return;
            }

            if (address.isEmpty()) {
                addressEt.setError("Enter address");
                addressEt.requestFocus();
                return;
            }

            if (addressType.isEmpty()) {
                Toast.makeText(this, "Please select Home / Office / Other", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(PersonalDetailsActivity.this, OrderSummaryActivity.class);
            intent.putExtra("roses", roses);
            intent.putExtra("lilies", lilies);
            intent.putExtra("tulips", tulips);
            intent.putExtra("total", total);

            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("email", email);
            intent.putExtra("address", address);
            intent.putExtra("addressType", addressType);

            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
