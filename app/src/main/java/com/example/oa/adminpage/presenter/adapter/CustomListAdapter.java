package com.example.oa.adminpage.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.local.Bill;
import com.example.oa.adminpage.data.local.Menu;
import com.example.oa.adminpage.presenter.activity.BillDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 7/5/17.
 */

public class CustomListAdapter<T extends RealmObject> extends RecyclerView.Adapter {

    static final int TYPE_LIST_INVOICE = 0;
    public static final int TYPE_GRID_INVOICE = 1;
    public static final int TYPE_LIST_FOOD = 3;

    private static final String TAG = "CustomListAdapter";
    private final int type;

    private RealmList<T> items = new RealmList<T>();
    private Context mActivity;

    public void setItems(RealmList<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public CustomListAdapter(Context mActivity, int type) {
        this.mActivity = mActivity;
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        RecyclerView.ViewHolder viewHolder = null;
        if (TYPE_LIST_INVOICE == viewType) {
            View view = mInflater.inflate(R.layout.list_invoice_item, parent, false);
            viewHolder = new ListViewHolder(view);
        } else if (TYPE_GRID_INVOICE == viewType) {
            View view = mInflater.inflate(R.layout.grid_invoice_item, parent, false);
            viewHolder = new GridViewHolder(view);
        } else if (TYPE_LIST_FOOD == viewType) {
            View view = mInflater.inflate(R.layout.list_food_item, parent, false);
            viewHolder = new FoodViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        Bill data = (Bill) items.get(position);
        if (holder instanceof ListViewHolder) {
            Bill data = (Bill) items.get(position);
            ListViewHolder hd = (ListViewHolder) holder;
            hd.itemTitle.setText(data.getUuid());

        } else if (holder instanceof GridViewHolder) {
            Bill data = (Bill) items.get(position);
            GridViewHolder hd = (GridViewHolder) holder;
            hd.item.setOnClickListener(v -> {
                BillDetailActivity.start(mActivity, data.getUuid());
            });
        }else if(holder instanceof FoodViewHolder){
            Menu data = (Menu) items.get(position);
            FoodViewHolder hd = (FoodViewHolder) holder;
            hd.itemName.setText(data.getName());
            hd.itemPrice.setText(data.getPrice());
            hd.itemSum.setText(data.getPrice());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @OnClick({R.id.item_name, R.id.item_price, R.id.item_sum})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.item_name:
                break;
            case R.id.item_price:
                break;
            case R.id.item_sum:
                break;
        }
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_content)
        LinearLayout itemContent;

        ListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.bill_item)
        RelativeLayout item;

        GridViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.item_price)
        TextView itemPrice;
        @BindView(R.id.item_sum)
        TextView itemSum;

        public FoodViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
