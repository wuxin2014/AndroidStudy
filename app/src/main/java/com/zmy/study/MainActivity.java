package com.zmy.study;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.zmy.study.launchMode.IndexActivity;
import com.zmy.study.service.ServiceActivity;
import com.zmy.study.webJs.WebViewActivity;
import com.zmy.study.webJs.WebViewActivity2;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private List<String> mData = new ArrayList<>();
    private String[] arr = {"launchModeDemo","serviceDemo", "webViewDemo", "webViewDemo2", "viewScrollDemo", "dragViewDemo"};
    private Class[] classes = {IndexActivity.class,  ServiceActivity.class,WebViewActivity.class, WebViewActivity2.class, OriginDragViewActivity.class,  DragActivity.class};

    private RecyclerView mRecyclerView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        Log.i("haha", ""+mData.size());
        mRecyclerView = findViewById(R.id.rv_list);

        // 注意设置LayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapter(this, mData);
        mRecyclerView.setAdapter(adapter);
        adapter.setItemClickListener(this);

    }

    public void getData() {
        for (int i=0; i<arr.length; i++) {
            mData.add(arr[i]);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, classes[position]);
        startActivity(intent);
    }
}
