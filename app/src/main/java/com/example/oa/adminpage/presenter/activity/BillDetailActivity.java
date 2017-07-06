package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.adapter.CustomListAdapter;
import com.example.oa.adminpage.presenter.adapter.CustomPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Phoenix on 7/6/17.
 */

public class BillDetailActivity extends BaseActivity {


    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.finish)
    Button finish;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new CustomListAdapter(this,CustomListAdapter.TYPE_LIST_FOOD);
        recyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.back, R.id.finish})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.finish:
                break;
        }
    }
}
