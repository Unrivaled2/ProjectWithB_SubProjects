package com.example.yangc.create_student_table_info;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class show_class extends AppCompatActivity {

    private List<myBean> myBeanList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_test);
        ListView listView = (ListView) findViewById(R.id.listview);
        init();
        myAdapter adapter = new myAdapter(show_class.this,R.layout.my_item,myBeanList);
        listView.setAdapter(adapter);



    }
    private void init(){
        myBean bean1 = new myBean("地理信息系统导论",R.mipmap.ic_launcher);
        myBeanList.add(bean1);

        myBean bean2 = new myBean("数据结构",R.mipmap.ic_launcher);
        myBeanList.add(bean2);

        myBean bean3 = new myBean("算法导论",R.mipmap.ic_launcher);
        myBeanList.add(bean3);

        myBean bean4 = new myBean("高数A",R.mipmap.ic_launcher);
        myBeanList.add(bean4);

        myBean bean5 = new myBean("物理A",R.mipmap.ic_launcher);
        myBeanList.add(bean5);

        myBean bean6 = new myBean("线性代数A",R.mipmap.ic_launcher);
        myBeanList.add(bean6);


    }
}