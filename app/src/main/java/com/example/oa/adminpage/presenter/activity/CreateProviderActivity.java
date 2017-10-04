package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.presenter.CreateProviderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Phoenix on 9/10/17.
 */
public class CreateProviderActivity extends BaseActivity {

    @BindView(R.id.name)
    EditText txtName;
    @BindView(R.id.image)
    EditText txtImage;
    @BindView(R.id.des)
    EditText txtDes;
    @BindView(R.id.address)
    EditText txtAddress;
    @BindView(R.id.url)
    EditText txtUrl;
    @BindView(R.id.lat)
    EditText txtLat;
    @BindView(R.id.longt)
    EditText txtLong;
    @BindView(R.id.open_hour)
    EditText txtOpenHour;
    @BindView(R.id.start)
    EditText txtStart;

    @Inject
    CreateProviderPresenter presenter;
    @BindView(R.id.ok)
    Button ok;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_provider);
        ButterKnife.bind(this);
        component.inject(this);
        initialize();
    }

    private void initialize() {

    }

    @OnClick(R.id.ok)
    public void onViewClicked() {
        String name = txtName.getText().toString();
        String address = txtAddress.getText().toString();
        String image = txtImage.getText().toString();
        String des = txtDes.getText().toString();
        String url = txtUrl.getText().toString();
        String openHour = txtOpenHour.getText().toString();
        String start = txtStart.getText().toString();
        presenter.createProvider(name,address,image,des,url,openHour,start);
    }

    /**
     * {
     "name" : " High Land",
     "image": "provider.jpg",
     "description":"ca phe HL",
     "address": "D2 street",
     "url": "hh.com",
     "latitude": "300",
     "longitude": "900",
     "openHour": "8:10",
     "star":"5"
     }
     */
}
