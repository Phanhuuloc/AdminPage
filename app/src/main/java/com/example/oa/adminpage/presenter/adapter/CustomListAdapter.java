package com.example.oa.adminpage.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.ODObject;
import com.example.oa.adminpage.data.local.Bill;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

/**
 * Created by Phoenix on 7/5/17.
 */

public class CustomListAdapter extends RecyclerView.Adapter {

     static final int TYPE_LIST_INVOICE = 0;
    public static final int TYPE_GRID_INVOICE = 1;
    public static final int TYPE_LIST_FOOD = 3;
    private static final int DUMMY_SIZE = 60;
    private static final String TAG = "CustomListAdapter";
    private final int type;

    private RealmList<Bill> items = new RealmList<>();
    private Context mActivity;

    public void setItems(RealmList<Bill> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public CustomListAdapter(Context mActivity, int type) {
        this.mActivity = mActivity;
        this.type = type;

//        initDummyData();
    }

    private void initDummyData() {
        for (int i = 0; i < DUMMY_SIZE; i++) {
            items.add(new Bill("Hoa don so " + i));
        }
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
            viewHolder = new GridViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Bill data = (Bill) items.get(position);
        if (holder instanceof ListViewHolder) {
            ListViewHolder hd = (ListViewHolder) holder;
            hd.itemTitle.setText(data.getUuid());
//            Log.d(TAG,data.getCode());
        } else if (holder instanceof GridViewHolder) {
            GridViewHolder hd = (GridViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_content)
        LinearLayout itemContent;

        ListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder {

        public GridViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolder {

    }
}
