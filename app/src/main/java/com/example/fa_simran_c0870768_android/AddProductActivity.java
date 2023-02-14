package com.example.fa_simran_c0870768_android;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {
    private EditText editTextId, editTextName, editTextDesc, editTextPrice, editTextLatitude= findViewById(R.id.editTextLatitude),editTextLongitude = findViewById(R.id.editTextLongitude);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        editTextId = findViewById(R.id.editTextId);
        editTextName = findViewById(R.id.editTextName);
        editTextDesc = findViewById(R.id.editTextDesc);
        editTextPrice = findViewById(R.id.editTextPrice);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        final String sPID = editTextId.getText().toString().trim();
        final String sName = editTextName.getText().toString().trim();
        final String sDesc = editTextDesc.getText().toString().trim();
        final String sPrice = editTextPrice.getText().toString().trim();
        final String sLatitude = editTextLatitude.getText().toString().trim();
        final String sLongitude = editTextLatitude.getText().toString().trim();
        if (sPID.isEmpty()) {
            editTextId.setError("Field required");
            editTextId.requestFocus();
            return;
        }
        if (sName.isEmpty()) {
            editTextName.setError("Field required");
            editTextName.requestFocus();
            return;
        }
        if (sDesc.isEmpty()) {
            editTextDesc.setError("Field required");
            editTextDesc.requestFocus();
            return;
        }

        if (sPrice.isEmpty()) {
            editTextPrice.setError("Field required");
            editTextPrice.requestFocus();
            return;
        }
        if (sLatitude.isEmpty()) {
            editTextLatitude.setError("Field required");
            editTextLatitude.requestFocus();
            return;
        }
//        class SaveTask extends AsyncTask<Void, Void, Void> {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//
//                //creating a task
//                Product product = new Product();
//                product.setPID(Integer.parseInt(sPID));
//                product.setName(sName);
//                product.setDesc(sDesc);
//                product.setPrice(Double.parseDouble(sPrice));
//                product.setLatitude(Double.parseDouble(sLatitude));
//                product.setLatitude(Double.parseDouble(sLongitude));
//
//                //adding to database
//                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                        .productDao()
//                        .insertProduct(product);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                finish();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
//            }
//        }
//
//        SaveTask st = new SaveTask();
//        st.execute();
//    }
    }
}
