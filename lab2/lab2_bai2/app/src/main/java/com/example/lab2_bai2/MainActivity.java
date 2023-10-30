package com.example.lab2_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.ed_name);
        Button button = findViewById(R.id.btn);
        ListView listView = findViewById(R.id.lv);
        TextView textView = findViewById(R.id.tv_pos);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Teo");
        arrayList.add("ti");
        arrayList.add("bin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          arrayList.add(editText.getText().toString());
                                          editText.getText().clear();
                                          adapter.notifyDataSetChanged();
                                      }
                                  });
            //5. Xử lý sự kiện chọn một phần tử trong ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("Position : "+position+";value ="+arrayList.get(position));
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(arrayList.get(position));
                adapter.notifyDataSetChanged();
                return false;
            }
        });
//6. xử lý sự kiện Long click

    }
}