package com.example.a18056.test_get_image_from_album;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zhengzhong
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhotoImageFragment fragment = new PhotoImageFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_contain, fragment)
                .commit();
    }
}
