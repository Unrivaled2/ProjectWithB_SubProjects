package com.example.yangc.create_student_table_info;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //该按钮可以实现创建数据库的功能
        dbHelper = new MyDatabaseHelper(this,"student_db",null,3);
        Button create_db = (Button)findViewById(R.id.create_database);
        create_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            };
        });
        Button add_stu_info_data = (Button)findViewById(R.id.add_data);
        add_stu_info_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","20171002186");
                values.put("class_name","117161");
                values.put("course_name","math");
                values.put("teacher_name","AA");
                db.insert("stu_info",null,values);
            };
        });
        Button select_course = (Button)findViewById(R.id.select_course);
        select_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OkHttpClient client = new OkHttpClient();
                Log.d("this","1111111111111111");

                RequestBody body = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("course_name","math")
                        .addFormDataPart("teacher_name","AA")
                        .build();
                Log.d("this","111177777777777771");

                final Request request = new Request.Builder()
                        .url("http://120.79.132.142/select_course/117171/20171002196")
                        .post(body)
                        .build();

                final Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            client.newCall(request).execute();
                        }catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
        final Button show_teacher = (Button)findViewById(R.id.show_teacher);
        show_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.yangc.create_student_table_info.show_teacher.class);
                startActivity(intent);
            }
        });

        Button update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("course_name","117175");
                db.update("stu_info",values,"course_name=?",new String[]{"math"});
            }
        });

        final Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("stu_info","course_name=?",new String[]{"math"});
            }
        });

        final Button query = (Button)findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("stu_info",null,null,null,
                        null,null,null);
                if(cursor.moveToFirst())
                {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        Log.d("this","id is " + id);
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.d("this","name is " + name);
                        String course_name = cursor.getString(cursor.getColumnIndex("course_name"));
                        Log.d("this","course_name is" + course_name);
                    }while(cursor.moveToNext());
                    cursor.close();
                }
            }
        });

        final Button show_item = (Button)findViewById(R.id.show_item);
        show_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),show_class.class);
                startActivity(intent);
            }
        });

    }
}
