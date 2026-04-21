package com.example.floristapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        TextView summaryText = findViewById(R.id.summaryText);
        Button placeOrderBtn = findViewById(R.id.placeOrderBtn);

        int roses = getIntent().getIntExtra("roses", 0);
        int lilies = getIntent().getIntExtra("lilies", 0);
        int tulips = getIntent().getIntExtra("tulips", 0);
        int total = getIntent().getIntExtra("total", 0);

        StringBuilder summary = new StringBuilder();

        if (roses > 0) {
            summary.append("Roses x").append(roses).append(" = ₹").append(roses * 100).append("\n");
        }
        if (lilies > 0) {
            summary.append("Lilies x").append(lilies).append(" = ₹").append(lilies * 120).append("\n");
        }
        if (tulips > 0) {
            summary.append("Tulips x").append(tulips).append(" = ₹").append(tulips * 150).append("\n");
        }

        summary.append("\nTotal = ₹").append(total);

        summaryText.setText(summary.toString());

        placeOrderBtn.setOnClickListener(v ->
                Toast.makeText(OrderSummaryActivity.this, "Order placed successfully 🌸", Toast.LENGTH_SHORT).show()
        );
    }
}