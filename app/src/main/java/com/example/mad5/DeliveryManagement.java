package com.example.mad5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mad5.Database.DBHandler;

import java.util.List;

public class DeliveryManagement extends AppCompatActivity {

   EditText name,phone,address,location;
   Button Search,Update,Delete;
   RadioButton Gift,Other;
   String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_management);


        name=findViewById(R.id.EnterNameDManager);
        phone=findViewById(R.id.enterPhone);
        address=findViewById(R.id.changeAddress);
        location=findViewById(R.id.changeLocation);
        Search=findViewById(R.id.searchButton);
        Update=findViewById(R.id.btnUpdate);
        Delete=findViewById(R.id.btnDelete);
        Gift=findViewById(R.id.RadiGift);
        Other=findViewById(R.id.radiOther);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
               List user= dbHandler.readAllInfo(name.getText().toString());

               if(user.isEmpty()){

                   Toast.makeText(DeliveryManagement.this, "No Delevery Available", Toast.LENGTH_SHORT).show();
                   name.setText(null);
               }else{

                   Toast.makeText(DeliveryManagement.this, "Delevery Found. Customer Name : "+user.get(0).toString(),
                           Toast.LENGTH_SHORT).show();
                       name.setText(user.get(0).toString());
                       phone.setText(user.get(1).toString());
                       address.setText(user.get(2).toString());
                       location.setText(user.get(3).toString());
                       if(user.get(4).toString().equals("Gift")){

                           Gift.setChecked(true);

                       }else{

                           Other.setChecked(true);


                       }



               }




            }
        });
        //Update Function
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(Gift.isChecked()){

                    type="Gift";
                }else{

                    type="other";
                }
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                Boolean status = dbHandler.updateInfo(name.getText().toString(),phone.getText().toString(),address.getText().toString(),
                        address.getText().toString(),type);

                  if(status){

                      Toast.makeText(DeliveryManagement.this, "Delevery Updated", Toast.LENGTH_SHORT).show();

                  }else{

                      Toast.makeText(DeliveryManagement.this, "Delivery Update Failed", Toast.LENGTH_SHORT).show();

                  }
            }
        });

//Delete Function

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deliteInfo(name.getText().toString());
                Toast.makeText(DeliveryManagement.this, "Delevery Cancelled!!", Toast.LENGTH_SHORT).show();

                name.setText(null);
                phone.setText(null);
                address.setText(null);
                location.setText(null);
                Gift.setChecked(false);
                Other.setChecked(false);

            }
        });





    }
}