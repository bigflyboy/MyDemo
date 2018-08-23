package com.wangzhiyuan.mydemo.RecyclerActivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.wangzhiyuan.mydemo.R;
import com.wangzhiyuan.ui.recyclerview.ArrayAdapter;
import com.wangzhiyuan.ui.recyclerview.PandaRefreshHeader;
import com.wangzhiyuan.ui.recyclerview.RefreshLayout;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private ArrayAdapter mArrayAdapter;
    private ArrayList<String> mArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.pull_recyclerview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        for (int i = 0; i < 10; i++) {
            mArrayList.add("这是第" + i + "条数据");
        }
        mArrayAdapter = new ArrayAdapter(this, mArrayList);
        PandaRefreshHeader panda = new PandaRefreshHeader(this);
        mRefreshLayout.setRefreshHeader(panda);
        mRecyclerView.setAdapter(mArrayAdapter);
        if (mRefreshLayout != null) {
            // 刷新状态的回调
            mRefreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // 延迟3秒后刷新成功
                    mRefreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mRefreshLayout.refreshComplete();
                        }
                    }, 500);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_1) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            return true;
        } else if (item.getItemId() == R.id.action_2) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(RecyclerActivity.this, 3));
            return true;
        } else if (item.getItemId() == R.id.action_3) {
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            return true;
        }
        return false;
    }
}
