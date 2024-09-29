package com.example.basiclistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
private ListView list_1;
private Button btnShow;
private String[] arr1;
private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        list_1.setOnItemClickListener(this);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              list_1.setAdapter(adapter);
            }
        });
    }

    private void initViews() {
        btnShow=findViewById(R.id.button);
        list_1=findViewById(R.id.lstChess);
        arr1=getResources().getStringArray(R.array.pieces);
        adapter =new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arr1);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String stone=arr1[position];
        String[] s;
        s=stone.split("-");
        Toast.makeText(this, s[1]+" was clicked", Toast.LENGTH_SHORT).show();
    }
}