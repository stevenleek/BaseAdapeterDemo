package com.example.likai.baseadapeterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i=0; i< 20;i++) {
            itemBeanList.add(new ItemBean(R.drawable.ic_launcher,"我是title "+ i, "this is the content "+i));
        }
        //将listview与适配器绑定在一起；
        ListView listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(new myAdapter(this,itemBeanList));
    }



}
