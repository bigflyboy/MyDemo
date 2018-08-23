package com.wangzhiyuan.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zybag on 2018/2/7.
 */

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ArrayViewHolder> {

    private ArrayList<String> mArray;

    public ArrayAdapter(Context context, ArrayList<String> array) {
        mArray = array;
    }
    @Override
    public ArrayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArrayViewHolder(View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null));
    }

    @Override
    public void onBindViewHolder(ArrayViewHolder holder, int position) {
        if(position!=getItemCount()-1){
            holder.mTextView.setText(mArray.get(position));
        }else{
            holder.mTextView.setText("加载更多");
        }
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    public static class ArrayViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;

        public ArrayViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
