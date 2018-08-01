package com.cargill.cargillfood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Calories extends AppCompatActivity {



     ImageView Qrcode;
     Button generate,fooditembutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        Qrcode = (ImageView)findViewById(R.id.barcode);
        generate = (Button)findViewById(R.id.generate);
        fooditembutton = findViewById(R.id.fooditembutton);

         String femai = Login.email;
         final String femail = femai.toString().trim();
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(femail, BarcodeFormat.QR_CODE,350,350);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    Qrcode.setImageBitmap(bitmap);

                }catch (WriterException e){
                    e.printStackTrace();
                }
            }

        });

        fooditembutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Calories.this,FoodMenu.class));
            }
        });
    }
}
