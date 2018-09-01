package com.wangzhiyuan.ui.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wangzhiyuan.mydemo.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zybag on 2018/2/7.
 */

public class ArrayAdapter2 extends RecyclerView.Adapter<ArrayAdapter2.ArrayViewHolder> {

    private ArrayList<String> mArray;
    int []ranColor ={R.color.aa,R.color.ss,R.color.dd,
            R.color.ff, R.color.gg, R.color.hh,R.color.jj,R.color.kk};
    Random random = new Random();

    public ArrayAdapter2(Context context, ArrayList<String> array) {
        mArray = array;
    }
    @Override
    public ArrayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArrayViewHolder(View.inflate(parent.getContext(), R.layout.simple_list_1, null));
    }

    @Override
    public void onBindViewHolder(ArrayViewHolder holder, int position) {
        if(position!=getItemCount()-1){
            holder.mTextView.setHeight((int)(100+400*Math.random()));
            holder.mTextView.setText(mArray.get(position));
            int randomcolor =random.nextInt(ranColor.length);
            holder.mTextView.setBackgroundColor(randomcolor);

            int color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            holder.mTextView.setBackgroundColor(color);
        }else{
            holder.mTextView.setText("加载更多");
        }
    }

    public void addData(String data){
        mArray.add(data);
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
