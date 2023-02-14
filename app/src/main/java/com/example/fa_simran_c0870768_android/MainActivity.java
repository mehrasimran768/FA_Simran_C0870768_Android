package com.example.fa_simran_c0870768_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts = findViewById(R.id.listViewProducts);
    private ProductDao productDAO;
    private List<Product> products;
    private ArrayAdapter<Product> adapter;
    private Button buttonAdd;
    private SearchView searchh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productDAO = new ProductDao(this);
        products = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(adapter);


        buttonAdd = findViewById(R.id.floating_button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(adapter);


        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Product product = products.get(position);
                Intent intent = new Intent(MainActivity.this, UpdateProductActivity.class);
                intent.putExtra("product", (CharSequence) product);
                startActivity(intent);
            }
        });
        //getProduct();
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }

    private void loadProducts() {
        products = productDAO.getAllProducts();
        adapter.clear();
        adapter.addAll(products);
        adapter.notifyDataSetChanged();
    }

    
        public void onProductAdded(Product product) {
            productDAO.insertProduct(product);
            loadProducts();
            listViewProducts.setVisibility(View.VISIBLE);

        }
    }


//    private void getProduct() {
//        class GetProduct extends AsyncTask<Void, Void, List<Product>> {
//
//            @Override
//            protected List<Product> doInBackground(Void... voids) {
//                List<Product> productList = DatabaseClient
//                        .getInstance(getApplicationContext())
//                        .getAppDatabase()
//                        .productDao()
//                        .getAllProducts();
//                return productList;
//            }
//
//            @Override
//            protected void onPostExecute(List<Product> products) {
//                super.onPostExecute(products);
//                ProductAdapter adapter = new ProductAdapter(MainActivity.this, products);
//                recyclerView.setAdapter(adapter);
//
//            }
//        }
//
//        GetProduct gt = new GetProduct();
//        gt.execute();
//    }

