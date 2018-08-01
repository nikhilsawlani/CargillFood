package com.cargill.cargillfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
     private Button mLogout;
    EditText weight , Fullname , age , height ;
    RadioButton male,female;
    myDbAdapter helper;
     private FirebaseAuth mAuth;
     private  FirebaseAuth.AuthStateListener mAuthlistener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       //mLogout = (Button)findViewById(R.id.button2) ;
        mAuth = FirebaseAuth.getInstance();
        Fullname = (EditText)findViewById(R.id.Fullname);
        age = (EditText)findViewById(R.id.age);
        weight = (EditText)findViewById(R.id.weight);
        height = (EditText)findViewById(R.id.height);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(Profile.this,Calories.class));
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.lifestyle);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.lifestyle,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
     String message = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public  void GenderInfo(View view){
      boolean checked = ((RadioButton) view).isChecked();

      switch (view.getId()){
          case R.id.male:
              if(checked)
                  Toast.makeText(this,"male",Toast.LENGTH_LONG).show();
                break;
          case R.id.female:
              if(checked)
                  Toast.makeText(this,"female",Toast.LENGTH_LONG).show();
                break;
      }
    }
}
