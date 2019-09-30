package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView=null;
    Button buttonkt;
    ArrayList<ThucUong>myList=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myList = new ArrayList<>();
        myList.add(new ThucUong("GA",5000));
        myList.add(new ThucUong("BO",3000));
        myList.add(new ThucUong("HEO",2000));
        ArrayAdapter<ThucUong> arrayAdapter
                = new ArrayAdapter<ThucUong>(this, android.R.layout.simple_list_item_multiple_choice,myList);
        listView=(ListView)findViewById(R.id.list_item);
        listView.setAdapter(arrayAdapter);

        buttonkt=(Button)findViewById(R.id.buttonkt);
        buttonkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                List<ThucUong> list = getItemChecked();
                intent.putExtra("list",(Serializable) list);
                startActivity(intent);
                finish();
            }
        });
    }
    public List<ThucUong> getItemChecked(){
        List<ThucUong> list = new ArrayList<>();
        //Chứa 1 dãy boolean
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        final int checkedItemCount = checkedItemPositions.size();
        for (int i = 0; i < checkedItemCount; i++) {
            int key = checkedItemPositions.keyAt(i);
            if (checkedItemPositions.get(key)) {
               list.add(myList.get(key));
            }
        }
        return list;
    }




}
