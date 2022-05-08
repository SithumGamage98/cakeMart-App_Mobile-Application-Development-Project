package com.example.mad5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mad5.Database.DBHandler;


public class MainActivity extends AppCompatActivity {

    EditText name,phone,address,location;
    Button submit;
    RadioButton Gift,other;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        name=findViewById(R.id.addNameDeli);
        phone=findViewById(R.id.addPhoneDili);
        address=findViewById(R.id.addDeliveryDili);
        location=findViewById(R.id.addLocationDeli);
        submit=findViewById(R.id.btnSubmit);
        Gift=findViewById(R.id.radioGiftDili);
        other=findViewById(R.id.RadioOther);

        //ADD New Delivery Functionn

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Gift.isChecked()){

                    type="Gift";
                }else{

                    type="other";
                }
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID =  dbHandler.addInfo(name.getText().toString(),phone.getText().toString(),address.getText().toString(),
                        location.getText().toString(),type);
                Toast.makeText(MainActivity.this, "Delivery Added. Delivery ID: "+ newID, Toast.LENGTH_SHORT).show();

                Intent i =new Intent(getApplicationContext(),admin1.class);
                startActivity(i);
            }
        });

    }


}
