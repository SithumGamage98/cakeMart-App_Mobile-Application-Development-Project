package com.example.mad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class admin1 extends AppCompatActivity {

    Button enter,search2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);

        enter=findViewById(R.id.btnenter);
        search2=findViewById(R.id.btnToSearch);



           enter.setOnClickListener(new View.OnClickListener() {
               @Override


               public void onClick(View view) {



                   Intent k =new Intent(getApplicationContext(),DeliveryManagement.class);
                   startActivity(k);


               }
           });





       search2.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {



                Intent L =new Intent(getApplicationContext(),DeliveryManagement.class);
                startActivity(L);


            }
        });





    }
}