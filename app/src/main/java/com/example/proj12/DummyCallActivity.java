package com.example.proj12;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DummyCallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dummy_call);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvContactName = findViewById(R.id.tvContactName);
        TextView tvCallInfo = findViewById(R.id.tvCallInfo);
        Button btnEndCall = findViewById(R.id.btnEndCall);
        Button btnBack = findViewById(R.id.btnBack);

        String contact = getIntent().getStringExtra("contact");

        tvCallInfo.setText(contact);

        btnEndCall.setOnClickListener(v -> endCall());
        btnBack.setOnClickListener(v -> finish());
    }

    private void endCall() {
        finish();
    }
}
