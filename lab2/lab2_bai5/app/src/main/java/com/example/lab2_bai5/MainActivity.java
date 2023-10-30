package com.example.lab2_bai5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner thumbnailSpinner;
        ThumbnailAdapter thumbnailAdapter;
        GridView gridView;
        DishAdapter adapter;
        List<Dish> dishes = new ArrayList<>();
        EditText editTextName;
        CheckBox checkBoxPromotion;
        Button btn;

        editTextName = (EditText) findViewById(R.id.ed_name);
        checkBoxPromotion = (CheckBox) findViewById(R.id.checkBox);
        btn = findViewById(R.id.btn);
        gridView = findViewById(R.id.gv);
        Thumbnail thumbnails[] = {Thumbnail.Thumbnail1, Thumbnail.Thumbnail2, Thumbnail.Thumbnail3, Thumbnail.Thumbnail4};
        thumbnailSpinner = findViewById(R.id.sp_thumbnail);

        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumbnail, R.layout.item_selected, thumbnails);
        thumbnailSpinner.setAdapter(thumbnailAdapter);

        adapter = new DishAdapter(this, R.layout.gridview_dish, dishes);
        gridView.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String DishName = editTextName.getText().toString();
                Thumbnail selected_thumbnail = thumbnails[thumbnailSpinner.getSelectedItemPosition()];
                boolean check = false;
                if(checkBoxPromotion.isChecked())
                    check = true;
                Dish dish = new Dish(DishName, selected_thumbnail,check);
                dishes.add(dish);
                adapter.notifyDataSetChanged();
                editTextName.getText().clear();
                thumbnailSpinner.setSelection(0);
                checkBoxPromotion.setChecked(false);
                Toast.makeText(MainActivity.this, "Added successfully!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}