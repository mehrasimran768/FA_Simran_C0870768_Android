package com.example.fa_simran_c0870768_android;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText id_input, name_input, desc_input, price_input,location_input;
    Button update_button, delete_button;

    String id, name, desc, price,location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        id_input = findViewById(R.id.Id_input2);
        name_input = findViewById(R.id.Name_input2);
        price_input = findViewById(R.id.Price_input2);
        desc_input = findViewById(R.id.Desc_input2);
        location_input = findViewById(R.id.Location_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(id);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                id = id_input.getText().toString().trim();
                name = name_input.getText().toString().trim();
                desc = desc_input.getText().toString().trim();
                price = price_input.getText().toString().trim();
                location = location_input.getText().toString().trim();
                myDB.updateData(id, name, desc, price, location);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("desc") && getIntent().hasExtra("price")&& getIntent().hasExtra("location")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            desc = getIntent().getStringExtra("desc");
            price = getIntent().getStringExtra("price");
            location = getIntent().getStringExtra("location");

            //Setting Intent Data
            id_input.setText(id);
            name_input.setText(name);
            desc_input.setText(desc);
            price_input.setText(price);
            location_input.setText(location);
            Log.d("stev", id+" "+name+" "+desc+" "+price+" "+location);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + id + " ?");
        builder.setMessage("Are you sure you want to delete " + id + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
