package com.korneev.android_app_lab1;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup colorGroup;
    private EditText inputField;
    private TextView resultField;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorGroup = findViewById(R.id.colorGroup);
        inputField = findViewById(R.id.inputField);
        resultField = findViewById(R.id.resultField);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputField.getText().toString().trim();
                int selectedId = colorGroup.getCheckedRadioButtonId();

                if (text.isEmpty() || selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Введіть всі дані!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int color = Color.BLACK;
                if (selectedId == R.id.radioRed) {
                    color = Color.RED;
                } else if (selectedId == R.id.radioGreen) {
                    color = Color.GREEN;
                } else if (selectedId == R.id.radioBlue) {
                    color = Color.BLUE;
                }

                resultField.setText(text);
                resultField.setTextColor(color);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputField.setText("");
                resultField.setText("");
                colorGroup.clearCheck();
            }
        });
    }
}