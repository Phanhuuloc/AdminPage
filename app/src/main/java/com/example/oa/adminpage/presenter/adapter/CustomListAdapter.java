package com.example.oa.adminpage.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.adminpage.R;
import com.example.oa.adminpage.data.ODObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 7/5/17.
 */

public class CustomListAdapter extends RecyclerView.Adapter {

    public static final int TYPE_LIST_INVOICE = 0;
    public static final int TYPE_GRID_INVOICE = 1;
    public static final int TYPE_LIST_FOOD = 3;
    private final int type;

    private List<ODObject> items = new ArrayList<>();
    private Context mActivity;

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
            viewHolder = new ImageViewHolder(view);
        } else if(TYPE_GRID_INVOICE == viewType) {
            View view = mInflater.inflate(R.layout.grid_invoice_item, parent, false);
            viewHolder = new GridViewHolder(view);
        }else if(TYPE_LIST_FOOD == viewType){
            View view = mInflater.inflate(R.layout.list_food_item, parent, false);
            viewHolder = new GridViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{

        public ListViewHolder(View itemView) {
            super(itemView);
        }
    }

    class GridViewHolder extends RecyclerView.ViewHolder{

        public GridViewHolder(View itemView) {
            super(itemView);
        }
    }
}
