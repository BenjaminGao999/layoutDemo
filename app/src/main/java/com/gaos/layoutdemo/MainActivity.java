package com.gaos.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRelativelaypoutDemo myRelativelaypoutDemo = new MyRelativelaypoutDemo(this);

        RelativeLayout mlayout = (RelativeLayout) findViewById(R.id.activity_main);
        mlayout.addView(myRelativelaypoutDemo, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }
}
