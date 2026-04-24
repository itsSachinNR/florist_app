package com.example.floristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private static final int ROSE_PRICE = 100;
    private static final int LILY_PRICE = 120;
    private static final int TULIP_PRICE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView billText = findViewById(R.id.billText);
        Button payBtn = findViewById(R.id.payBtn);
        Button backBtn = findViewById(R.id.backBtn);

        int roses = getIntent().getIntExtra("roses", 0);
        int lilies = getIntent().getIntExtra("lilies", 0);
        int tulips = getIntent().getIntExtra("tulips", 0);
        int total = getIntent().getIntExtra("total", 0);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");

        StringBuilder bill = new StringBuilder();
        bill.append("Billing Details\n\n");

        if (roses > 0) {
            bill.append("🌹 Roses x ").append(roses)
                    .append(" = ₹").append(roses * ROSE_PRICE).append("\n");
        }

        if (lilies > 0) {
            bill.append("🌼 Lilies x ").append(lilies)
                    .append(" = ₹").append(lilies * LILY_PRICE).append("\n");
        }

        if (tulips > 0) {
            bill.append("🌷 Tulips x ").append(tulips)
                    .append(" = ₹").append(tulips * TULIP_PRICE).append("\n");
        }

        bill.append("\n----------------------\n");
        bill.append("Total Amount: ₹").append(total).append("\n\n");

        bill.append("Delivery Details\n\n");
        bill.append("Name: ").append(name != null ? name : "-").append("\n");
        bill.append("Phone: ").append(phone != null ? phone : "-").append("\n");
        bill.append("Email: ").append(email != null ? email : "-").append("\n");
        bill.append("Address: ").append(address != null ? address : "-").append("\n");

        billText.setText(bill.toString());

        backBtn.setOnClickListener(v -> finish());

        payBtn.setOnClickListener(v ->
                Toast.makeText(ThirdActivity.this,
                        "Payment successful 🌸",
                        Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
