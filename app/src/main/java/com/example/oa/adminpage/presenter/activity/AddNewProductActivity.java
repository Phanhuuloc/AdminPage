package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.presenter.CreateItemPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddNewProductActivity extends BaseActivity {

    @Inject
    CreateItemPresenter presenter;

    @BindView(R.id.item_category)
    EditText itemCategory;
    @BindView(R.id.item_name)
    EditText itemName;
    @BindView(R.id.item_price)
    EditText itemPrice;
    @BindView(R.id.item_des)
    EditText itemDes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        ButterKnife.bind(this);
        component.inject(this);
    }

    @OnClick(R.id.ok)
    public void onViewClicked(View view) {
        String provider = "0164b0d3-2a71-4e64-b8e8-760905d38e9b";
        String category = itemCategory.getText().toString();
        String name = itemName.getText().toString();
        String price = itemPrice.getText().toString();
        String des = itemDes.getText().toString();
        String note = "nothing";
        presenter.createMenuItem(provider, category, name, price, des, note);
    }
}
