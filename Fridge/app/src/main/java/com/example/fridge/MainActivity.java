package com.example.fridge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="Prod App";
    Button btn_add;
    Menu menu;

    Applic applic = (Applic) this.getApplication();

    List<Products> ProductsList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide both the navigation bar and the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        //get me to frontpage of app


        ProductsList = applic.getProductsList();

        Log.d(TAG, "onCreate: " + ProductsList.toString());

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Buttons.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new ItemAdapter(ProductsList, this);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ascend_descend, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mn_atoz:
                Collections.sort(ProductsList, Products.Prodnameatoz);
                Toast.makeText(this, "Sorting by name: A to Z", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.mn_ztoa:
                Collections.sort(ProductsList, Products.Prodnameztoa);
                Toast.makeText(this, "Sorting by name: Z to A", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.mn_asc:
                Collections.sort(ProductsList, Products.Prodexpdateasc);
                Collections.sort(ProductsList, Products.ProdexpdateMMasc);
                Collections.sort(ProductsList, Products.Prodexpdateyyyyasc);
                Toast.makeText(this, "Sorting by date: Ascending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
            case R.id.mn_desc:
                Collections.sort(ProductsList, Products.Prodexpdatedesc);
                Collections.sort(ProductsList, Products.ProdexpdateMMdesc);
                Collections.sort(ProductsList, Products.Prodexpdateyyyydesc);
                Toast.makeText(this, "Sorting by date: Descending", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}