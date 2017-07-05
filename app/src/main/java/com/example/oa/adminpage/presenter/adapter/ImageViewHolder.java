package com.example.oa.adminpage.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.ODObject;
import com.example.oa.adminpage.presenter.activity.DetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Phoenix on 5/29/17.
 */

class ImageViewHolder extends RecyclerView.ViewHolder {
    ODObject data;
    Context context;
//    @BindView(R.id.item_title)
//    TextView itemTitle;
//    @BindView(R.id.item_address)
//    TextView itemAddress;
//    @BindView(R.id.item_description)
//    TextView itemDescription;
//    @BindView(R.id.item_time)
//    TextView itemTime;
//    @BindView(R.id.item_content)
//    LinearLayout itemContent;

    public ImageViewHolder(View view) {
        super(view);
        context = view.getContext();
        ButterKnife.bind(this,view);
    }

    @OnClick(R.id.item_content)
    public void onViewClicked() {
        DetailActivity.start(context);
    }
}
