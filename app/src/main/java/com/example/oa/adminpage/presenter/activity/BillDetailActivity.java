package com.example.oa.adminpage.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.presenter.BillDetailPresenter;
import com.example.oa.adminpage.presenter.adapter.CustomListAdapter;
import com.example.oa.adminpage.presenter.view.BillDetailView;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Phoenix on 7/6/17.
 */

public class BillDetailActivity extends BaseActivity implements BillDetailView {
    public static final String BILL_ID = "BILL_ID";
    @Inject
    BillDetailPresenter presenter;

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.finish)
    Button finish;
    @BindView(R.id.img_success)
    CircleImageView imgSuccess;
    private CustomListAdapter<Menu> adapter;
    private IconicsDrawable ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);
        ButterKnife.bind(this);
        initialize();
        component.inject(this);
        presenter.setView(this);
        presenter.getBillDetail(getIntent().getStringExtra(BILL_ID));
    }

    public static void start(Context context, String bid) {
        Intent intent = new Intent(context, BillDetailActivity.class);
        intent.putExtra(BILL_ID, bid);
        context.startActivity(intent);
    }

    private void initialize() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new CustomListAdapter(this, CustomListAdapter.TYPE_LIST_FOOD);
        recyclerView.setAdapter(adapter);

        ic = new IconicsDrawable(this)
                .icon(GoogleMaterial.Icon.gmd_done)
                .color(Color.GREEN)
                .backgroundColor(Color.LTGRAY)
                .paddingDp(10)
                .sizeDp(80);
        imgSuccess.setImageDrawable(ic);
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

    @Override
    public void renderNetData(Bill bill) {
        adapter.setItems(bill.getMons());
    }
}
