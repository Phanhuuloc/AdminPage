package com.example.oa.adminpage.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.local.Category;
import com.example.oa.adminpage.data.local.Provider;
import com.example.oa.adminpage.presenter.CreateCategoryPresenter;
import com.example.oa.adminpage.presenter.CreateProviderPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Phoenix on 9/10/17.
 */
public class CreateCategoryActivity extends BaseActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.image)
    EditText image;

    @Inject
    CreateCategoryPresenter presenter;
    @BindView(R.id.ok)
    Button ok;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        ButterKnife.bind(this);
        component.inject(this);
        initialize();
    }

    private void initialize() {

    }

    @OnClick(R.id.ok)
    public void onViewClicked() {
        Category p = new Category();
        p.setName(name.getText().toString());
        p.setDefaultImage(image.getText().toString());
        presenter.createCategory(p);
    }

    /**
     * {
     "name" : "Tra sua",
     "defaultImage": "tt.jpg",
     "provider":{
     "uuid": "6c3e8069-f81e-4d19-ad59-c0338c2b926b"
     }
     }
     */
}
