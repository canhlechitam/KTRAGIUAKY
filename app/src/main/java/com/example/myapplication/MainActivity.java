package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonchon,buttonluu;
    EditText editText;
    TextView textViewdoan;
    List<ThucUong> list = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewdoan=(TextView)findViewById(R.id.textViewdoan);
        Intent intent = getIntent();
        if(intent != null){
            list = (List<ThucUong>) intent.getSerializableExtra("list");
            if(list != null){
                textViewdoan.setText(list.toString());
            }
        }

        editText=(EditText)findViewById(R.id.textsoban);
        buttonluu=(Button)findViewById(R.id.btluu);
        buttonchon=(Button)findViewById(R.id.btchon);
        buttonchon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        buttonluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("list_order",MODE_PRIVATE).edit();
                editor.putString(editText.getText().toString(),list.toString());
                editor.apply();
            }
        });

    }
}
