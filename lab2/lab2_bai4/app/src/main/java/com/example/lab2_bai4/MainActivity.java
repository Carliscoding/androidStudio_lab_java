package com.example.lab2_bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edid = findViewById(R.id.ed_id);
        EditText edname = findViewById(R.id.ed_name);
        CheckBox cb = findViewById(R.id.checkBox);
        Button btn = findViewById(R.id.btn);
        ListView lv = (ListView) findViewById(R.id.lv);



        ArrayList<Employee> arr = new ArrayList<>();
        EmployeeAdapter adapter = new EmployeeAdapter(this, R.layout.item_employee, arr);
        lv.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            String id;
            Employee employee = null;
            String fullname;
            boolean manager;

            @Override
            public void onClick(View v) {
                id =  edid.getText().toString();
                fullname = edname.getText().toString();
                if(cb.isChecked()){
                    manager = true;
                    employee = new Employee();
                    employee.setId(id);
                    employee.setFullName(fullname);
                    employee.setManager(manager);

                    arr.add(employee);
                    adapter.notifyDataSetChanged();
                }else{
                    manager = false;
                    employee = new Employee();
                    employee.setId(id);
                    employee.setFullName(fullname);
                    employee.setManager(manager);
                    arr.add(employee);
                    adapter.notifyDataSetChanged();
                }
                edid.getText().clear();
                edname.getText().clear();
                cb.setChecked(false);
                edid.requestFocus();
            }
        });
    }

}