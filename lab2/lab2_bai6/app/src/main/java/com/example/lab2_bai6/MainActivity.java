package com.example.lab2_bai6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EmployeeAdapter adapter;
    RecyclerView rv;
    Button btn;
    EditText ed_it;
    EditText fullname;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<Employee> employees = new ArrayList<Employee>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_add_new_employee);
        rv = (RecyclerView) findViewById(R.id.rv_employee);
        ed_it = (EditText) findViewById(R.id.et_new_eployee_id);
        fullname = (EditText) findViewById(R.id.et_new_eployee_name);
        checkbox = (CheckBox) findViewById(R.id.ckb_new_eployee_isManager);
        adapter = new EmployeeAdapter(employees);
        rv.setAdapter(adapter);

        btn.setOnClickListener((view) -> {
            Employee employee = new Employee(ed_it.getText().toString(), fullname.getText().toString(), checkbox.isChecked());
            employees.add(employee);
            adapter.notifyItemInserted(employees.size() - 1);

            ed_it.setText("");
            fullname.setText("");
            checkbox.setChecked(false);
            ed_it.requestFocus();
        });

    }
}