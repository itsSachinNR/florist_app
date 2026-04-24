package com.example.floristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderSummaryActivity extends AppCompatActivity {

    private static final int ROSE_PRICE = 100;
    private static final int LILY_PRICE = 120;
    private static final int TULIP_PRICE = 150;

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
            summary.append("🌹 Roses x ").append(roses)
                    .append(" = ₹").append(roses * ROSE_PRICE).append("\n");
        }

        if (lilies > 0) {
            summary.append("🌼 Lilies x ").append(lilies)
                    .append(" = ₹").append(lilies * LILY_PRICE).append("\n");
        }

        if (tulips > 0) {
            summary.append("🌷 Tulips x ").append(tulips)
                    .append(" = ₹").append(tulips * TULIP_PRICE).append("\n");
        }

        if (summary.length() == 0) {
            summary.append("No items selected.");
            placeOrderBtn.setEnabled(false);
        } else {
            summary.append("\n----------------------\n");
            summary.append("Total Amount: ₹").append(total);
            placeOrderBtn.setEnabled(true);
        }

        summaryText.setText(summary.toString());

        placeOrderBtn.setOnClickListener(v -> {
            Toast.makeText(OrderSummaryActivity.this,
                    "Moving to billing screen...",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(OrderSummaryActivity.this, ThirdActivity.class);
            intent.putExtra("roses", roses);
            intent.putExtra("lilies", lilies);
            intent.putExtra("tulips", tulips);
            intent.putExtra("total", total);
            startActivity(intent);
        });
    }
}
