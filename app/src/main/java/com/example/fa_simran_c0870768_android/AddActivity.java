package com.example.fa_simran_c0870768_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    EditText id_input, name_input, price_input,desc_input,location_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        id_input = findViewById(R.id.Id_input);
        name_input = findViewById(R.id.Name_input);
        price_input = findViewById(R.id.Price_input);
        desc_input = findViewById(R.id.Desc_input);
        location_input = findViewById(R.id.Location_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(id_input.getText().toString().trim(),
                        name_input.getText().toString().trim(),
                        desc_input.getText().toString().trim(),
                        location_input.getText().toString().trim(),
                        Integer.valueOf(price_input.getText().toString().trim())
                        );
            }
        });
    }
}
