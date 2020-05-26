package com.example.weatherinfo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class zActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        final AlertDialog.Builder builder = new AlertDialog.Builder(zActivity.this);
        View v2 = getLayoutInflater().inflate(R.layout.interneterr, null);
        TextView b = v2.findViewById(R.id.button3);
        builder.setView(v2);
        final AlertDialog dialog = builder.create();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                return;
//              builder.setView(v2);
            }

        });
        dialog.show();
    }
}
