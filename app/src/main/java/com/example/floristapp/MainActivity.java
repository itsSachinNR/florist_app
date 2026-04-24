package com.example.floristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int roses = 0;
    private int lilies = 0;
    private int tulips = 0;

    private TextView roseQty;
    private TextView lilyQty;
    private TextView tulipQty;
    private TextView totalText;

    private static final int ROSE_PRICE = 100;
    private static final int LILY_PRICE = 120;
    private static final int TULIP_PRICE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roseQty = findViewById(R.id.roseQty);
        lilyQty = findViewById(R.id.lilyQty);
        tulipQty = findViewById(R.id.tulipQty);
        totalText = findViewById(R.id.totalText);

        Button orderBtn = findViewById(R.id.orderBtn);

        updateUI();

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = calculateTotal();

                if (total == 0) {
                    Toast.makeText(MainActivity.this,
                            "Please select at least one flower",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                intent.putExtra("roses", roses);
                intent.putExtra("lilies", lilies);
                intent.putExtra("tulips", tulips);
                intent.putExtra("total", total);
                startActivity(intent);
            }
        });
    }

    public void addRose(View view) {
        roses++;
        updateUI();
    }

    public void removeRose(View view) {
        if (roses > 0) {
            roses--;
        }
        updateUI();
    }

    public void addLily(View view) {
        lilies++;
        updateUI();
    }

    public void removeLily(View view) {
        if (lilies > 0) {
            lilies--;
        }
        updateUI();
    }

    public void addTulip(View view) {
        tulips++;
        updateUI();
    }

    public void removeTulip(View view) {
        if (tulips > 0) {
            tulips--;
        }
        updateUI();
    }

    private void updateUI() {
        roseQty.setText(String.valueOf(roses));
        lilyQty.setText(String.valueOf(lilies));
        tulipQty.setText(String.valueOf(tulips));
        totalText.setText("Estimated Total: ₹" + calculateTotal());
    }

    private int calculateTotal() {
        return (roses * ROSE_PRICE) + (lilies * LILY_PRICE) + (tulips * TULIP_PRICE);
    }
}
