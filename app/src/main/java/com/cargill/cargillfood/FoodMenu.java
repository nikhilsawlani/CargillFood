package com.cargill.cargillfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FoodMenu extends AppCompatActivity {
     TextView calleft;

    //ListView listView;
    private  ArrayList<String> list = new ArrayList<String>();;
   int cnt=0;
   int caleft=2000;
    //ArrayAdapter<String> adapter;
    Monday monday;
    Tuesday tuesday;
    Wednesday wednesday;
    Thursday thursday;
    Friday friday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
       ListView listView = (ListView)findViewById(R.id.fooditemlist);
        generateListContent();
        listView.setAdapter(new MyArrayAdapter(this,R.layout.food_item,list));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FoodMenu.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FoodMenu.this,"Items Selected",Toast.LENGTH_LONG).show();
               startActivity(new Intent(FoodMenu.this,Review.class));
            }
        });
    }



    private void generateListContent() {





        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        Log.v("food",dayOfTheWeek);

        if(dayOfTheWeek.equals("Monday") ) {
            Log.v("inside",dayOfTheWeek);
            FirebaseDatabase database;
            DatabaseReference ref;
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Monday");
            final ListView listView = (ListView)findViewById(R.id.fooditemlist);

            monday = new Monday();
            //dayofweek = (TextView)findViewById(R.id.textView4) ;

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    //int i =0;
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        monday = ds.getValue(Monday.class);

                        list.add(monday.getFooditem() + ":" + monday.getCal() );
                            //Log.v("food", String.valueOf(i));

                    }
                    listView.setAdapter(new MyArrayAdapter(FoodMenu.this,R.layout.food_item,list));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        }

        else if (dayOfTheWeek.equals("Tuesday")){

            FirebaseDatabase database;
            DatabaseReference ref;
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Tuesday");
            //list = new ArrayList<>();
            //adapter = new ArrayAdapter<String>(this, R.layout.food_item, R.id.food, list);
            tuesday = new Tuesday();
            //dayofweek = (TextView)findViewById(R.id.textView4) ;
            final ListView listView = (ListView)findViewById(R.id.fooditemlist);

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        tuesday = ds.getValue(Tuesday.class);
                        list.add(tuesday.getFooditem() + ":" + tuesday.getCal());


                    }
                    listView.setAdapter(new MyArrayAdapter(FoodMenu.this,R.layout.food_item,list));
                    //listView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }


        else if (dayOfTheWeek.equals("Wednesday")){

            FirebaseDatabase database;
            DatabaseReference ref;
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Wednesday");
            //list = new ArrayList<>();
            //adapter = new ArrayAdapter<String>(this, R.layout.food_item, R.id.food, list);
            wednesday = new Wednesday();
            //dayofweek = (TextView)findViewById(R.id.textView4) ;
            final ListView listView = (ListView)findViewById(R.id.fooditemlist);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        wednesday = ds.getValue(Wednesday.class);
                        list.add(wednesday.getFooditem() + ":" + wednesday.getCal());


                    }
                    listView.setAdapter(new MyArrayAdapter(FoodMenu.this,R.layout.food_item,list));
                    //listView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }

        else if (dayOfTheWeek.equals("Thursday")){

            FirebaseDatabase database;
            DatabaseReference ref;
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Thursday");
            //list = new ArrayList<>();
            //adapter = new ArrayAdapter<String>(this, R.layout.food_item, R.id.food, list);
            thursday = new Thursday();
            //dayofweek = (TextView)findViewById(R.id.textView4) ;
            final ListView listView = (ListView)findViewById(R.id.fooditemlist);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        thursday = ds.getValue(Thursday.class);
                        list.add(thursday.getFooditem() + ":" + thursday.getCal());


                    }
                    listView.setAdapter(new MyArrayAdapter(FoodMenu.this,R.layout.food_item,list));
                    //listView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }

        else if (dayOfTheWeek.equals("Friday")){

            FirebaseDatabase database;
            DatabaseReference ref;
            database = FirebaseDatabase.getInstance();
            ref = database.getReference("Friday");
            //list = new ArrayList<>();
            //adapter = new ArrayAdapter<String>(this, R.layout.food_item, R.id.food, list);
            friday = new Friday();
            //dayofweek = (TextView)findViewById(R.id.textView4) ;
            final ListView listView = (ListView)findViewById(R.id.fooditemlist);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {


                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        friday = ds.getValue(Friday.class);
                        list.add(friday.getFooditem() + ":" + friday.getCal());


                    }
                    listView.setAdapter(new MyArrayAdapter(FoodMenu.this,R.layout.food_item,list));
                    //listView.setAdapter(adapter);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }

        else if (dayOfTheWeek.equals("Saturday") || dayOfTheWeek.equals("Sunday")){

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_LONG);
            snackbar.show();

        }



    }


    public class MyArrayAdapter extends ArrayAdapter<String>{

          public   int layout;
        public List<String> mObjects;
        public MyArrayAdapter( Context context, int resource,  List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }


        @Override
        public View getView(final int position,  View convertView,  ViewGroup parent) {
            calleft = (TextView)findViewById(R.id.calleft);
            calleft.setText(String.valueOf(2000));
                Viewholder external = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                Viewholder viewholder = new Viewholder();
                viewholder.title = (TextView)convertView.findViewById(R.id.food);
                viewholder.count = (TextView) convertView.findViewById(R.id.textView2);
                viewholder.add = (ImageButton) convertView.findViewById(R.id.button5);
                viewholder.sub = (ImageButton)convertView.findViewById(R.id.button6);
                convertView.setTag(viewholder);
            }


               external = (Viewholder)convertView.getTag();
            final int ccount[] = {0};

            final Viewholder finalExternal = external;
            external.add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(getContext(),"Button was clicked" + position,Toast.LENGTH_LONG).show();
                        String full = getItem(position);
                        String [] sep = full.split(":");
                        Log.v("fooditemenu",sep[1]) ;
                        Log.v("fooditemenu",String.valueOf(position)) ;

                        finalExternal.count.setText(String.valueOf(++ccount[0]));
                        caleft = caleft-Integer.parseInt(sep[1]);
                        calleft.setText(String.valueOf(caleft));
                    }
                });



            external.sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(getContext(),"Button was clicked" + position,Toast.LENGTH_LONG).show();

                    String full = getItem(position);
                    String [] sep = full.split(":");
                    if(ccount[0]>0) {

                        finalExternal.count.setText(String.valueOf(--ccount[0]));
                        caleft = caleft+Integer.parseInt(sep[1]);
                        calleft.setText(String.valueOf(caleft));
                    }
                }
            });
            //external.count.setText(String.valueOf(cnt));
             external.title.setText(getItem(position));




            return convertView;
        }

    }



    public  class Viewholder {
        TextView title;
        TextView count;
        ImageButton add;
        ImageButton sub;

    }
}
