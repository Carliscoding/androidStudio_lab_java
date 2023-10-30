package com.example.lab2_bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed_id ;
    EditText ed_name;
    RadioButton rb_ct ;
    RadioButton rb_tv ;
    Button btn;
    ListView lv;
    RadioGroup rgType;
    Employee employee;
    ArrayList<Employee> arrayList = new ArrayList<>();
    ArrayAdapter<Employee> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_id = findViewById(R.id.ed_id);
        ed_name = findViewById(R.id.ed_name);
        rb_ct = findViewById(R.id.rb_ct);
        rb_tv = findViewById(R.id.rb_tv);
        btn = findViewById(R.id.btn);
        lv = findViewById(R.id.lv);
        rgType= findViewById(R.id.rgType);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEmployee();
            }
        });
    }
    public void addNewEmployee() {
//Lấy ra đúng id của Radio Button được checked
        int radId = rgType.getCheckedRadioButtonId();
        String id = ed_id.getText().toString();
        String name = ed_name.getText().toString();
        if (radId == R.id.rb_ct ){
//tạo instance là FullTime
            employee = new EmployeeFullTime();
        } else {
//Tạo instance là Partime
            employee = new EmployeeParttime();
        }
//FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
        employee.setId(id);
        employee.setName(name);
//Đưa employee vào ArrayList
        arrayList.add(employee);
//Cập nhập giao diện
        adapter.notifyDataSetChanged();
        ed_id.getText().clear();
        ed_name.getText().clear();
    }

}