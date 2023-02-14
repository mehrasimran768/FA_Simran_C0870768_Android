package com.example.fa_simran_c0870768_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProductActivity extends AppCompatActivity {
    private EditText editTextId, editTextName, editTextDesc, editTextPrice, editTextLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        final Product product = (Product) getIntent().getSerializableExtra("product");

        loadTask(product);

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                updateTask(product);
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateProductActivity.this);
                builder.setTitle("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //deleteTask(product);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }
        });
    }

    private void loadTask(Product product) {
        editTextId.setText(product.getPID());
        editTextName.setText(product.getName());
        editTextDesc.setText(product.getDesc());
        editTextPrice.setText((int) product.getPrice());
        editTextLocation.setText((int) product.getLatitude());
        editTextLocation.setText((int) product.getLongitude());
    }

    private void updateTask(final Product product) {
        final String sPID = editTextId.getText().toString().trim();
        final String sName = editTextName.getText().toString().trim();
        final String sDesc = editTextDesc.getText().toString().trim();
        final String sPrice = editTextPrice.getText().toString().trim();
        final String sLocation = editTextLocation.getText().toString().trim();
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
        if (sLocation.isEmpty()) {
            editTextLocation.setError("Field required");
            editTextLocation.requestFocus();
            return;
        }
//        class UpdateTask extends AsyncTask<Void, Void, Void> {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                product.setPID(Integer.parseInt(sPID));
//                product.setName(sName);
//                product.setDesc(sDesc);
//                product.setPrice(Double.parseDouble(sPrice));
//                product.setLatitude(Double.parseDouble(sLocation));
//                product.setLongitude(Double.parseDouble(sLocation));
//                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                        .productDao()
//                        .updateProduct(product);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
//                finish();
//                startActivity(new Intent(UpdateProductActivity.this, MainActivity.class));
//            }
//        }
//
//        UpdateTask ut = new UpdateTask();
//        ut.execute();
//    }
//
//
//    private void deleteTask(final Product task) {
//        class DeleteTask extends AsyncTask<Void, Void, Void> {
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
//                        .productDao()
//                        .deleteProduct(task);
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
//                finish();
//                startActivity(new Intent(UpdateProductActivity.this, MainActivity.class));
//            }
//        }
//
//        DeleteTask dt = new DeleteTask();
//        dt.execute();
//
//    }

    }
}