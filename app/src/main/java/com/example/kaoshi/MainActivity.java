package com.example.kaoshi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kaoshi.myview.MyStreamView;
import com.example.kaoshi.myview.MyTitleView;
import com.example.kaoshi.sqlite.Dao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private Dao dao;
    private MyStreamView searchView;
    private MyTitleView titleView;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleView = findViewById(R.id.title);
        searchView = findViewById(R.id.search);
        btn = findViewById(R.id.btn);

        dao = new Dao(MainActivity.this);
        //初始数据
        initData();
        //查询
        showData();

        titleView.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //加入到数据库
                if (!titleView.getEditText().getText().toString().isEmpty()){
                    dao.insert(titleView.getEditText().getText().toString());
                }
                showData();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空数据库（历史记录）
                dao.delete();
                showData();
            }
        });
    }
    //查询数据库并刷新视图
    private void showData() {
        //先初始化集合与视图
        list.clear();
        searchView.removeAllViews();
        //查询数据    遍历添加视图
        list.addAll(dao.select());
        for (int i = 0; i < list.size(); i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(list.get(i));
            textView.setTextSize(25);
            searchView.addView(textView);
        }
        //刷新视图
        searchView.invalidate();
    }
    //初始数据
    public void initData(){
        dao.insert("笔记本");
        dao.insert("空气净化器");
        dao.insert("安卓手机");
        dao.insert("超级大号圆珠笔");
        dao.insert("空气滤芯");
        dao.insert("超级大号刚笔");
    }
}
