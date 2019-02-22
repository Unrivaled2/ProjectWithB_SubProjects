package com.example.yangc.create_student_table_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class show_teacher extends AppCompatActivity {

    private List<myBean> myBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_layout);
        ListView listView = (ListView) findViewById(R.id.listview_teacher);
        init();
        myAdapter_teacher adapter = new myAdapter_teacher(show_teacher.this,R.layout.my_teacher,myBeanList);
        listView.setAdapter(adapter);

    }
    private void init(){
        myBean bean1 = new myBean("老师A",R.mipmap.ic_launcher);
        myBeanList.add(bean1);

        myBean bean2 = new myBean("老师B",R.mipmap.ic_launcher);
        myBeanList.add(bean2);

        myBean bean3 = new myBean("老师C",R.mipmap.ic_launcher);
        myBeanList.add(bean3);


    }
}