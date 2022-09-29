package com.example.fridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class Buttons extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    List<Products> ProductsList;
    EditText et_productname, et_expirydate, et_quantno, et_imagelink, et_expirymm, et_expiryyyy;
    int id, quantquant; TextView tv_id;
    Applic applic = (Applic) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        ProductsList = applic.getProductsList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_productname = findViewById(R.id.et_productname);
        et_expirydate = findViewById(R.id.et_expirydate);
        et_expirymm = findViewById(R.id.et_expirydateMM);
        et_expiryyyy = findViewById(R.id.et_expirydateyyyy);
        et_quantno = findViewById(R.id.et_quantno);
        et_imagelink = findViewById(R.id.et_imagelink);
        tv_id = findViewById(R.id.tv_id);

        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        quantquant= intent.getIntExtra("quantityno", -1);
        Products products = null;

        if (id >= 0){
            for (Products prods: ProductsList) {
                if (prods.getId() == id){
                    products = prods;
                }
            }
            et_productname.setText(products.getProdname());
            et_expirydate.setText(String.valueOf(products.getExpirydate()));
            et_expirymm.setText(String.valueOf(products.getExpiryMM()));
            et_expiryyyy.setText(String.valueOf(products.getExpiryyyy()));
            et_imagelink.setText(products.getImageLink());
            et_quantno.setText(String.valueOf(products.getQuantityno()));
            tv_id.setText(String.valueOf(products.getId()));
        }else{
        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if ( id >= 0 ){
                        Products uppingprods = new Products(id, et_productname.getText().toString(), Integer.parseInt(et_expirydate.getText().toString()),
                                et_imagelink.getText().toString(),Integer.parseInt(et_quantno.getText().toString()), Integer.parseInt(et_expirymm.getText().toString()),
                                Integer.parseInt(et_expiryyyy.getText().toString()));
                        ProductsList.add(uppingprods);
                    }else {
                        int nextId = applic.getNextID();
                        Products addingprod = new Products(nextId, et_productname.getText().toString(), Integer.parseInt(et_expirydate.getText().toString()),
                                et_imagelink.getText().toString(),Integer.parseInt(et_quantno.getText().toString()), Integer.parseInt(et_expirymm.getText().toString()),
                                Integer.parseInt(et_expiryyyy.getText().toString()));
                        ProductsList.add(addingprod);
                        applic.setNextID(nextId++);
                    }
                //int i = Integer.parseInt(myText.getText());
                String a = et_productname.getText().toString();
                //String b = et_expirydate.getText().toString();
                //String c = et_quantno.getText().toString();
                //String d = et_imagelink.getText().toString();
                if(a.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill in the missing blanks first.", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                        Intent intent = new Intent(Buttons.this, MainActivity.class);
                        startActivity(intent);
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Buttons.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}