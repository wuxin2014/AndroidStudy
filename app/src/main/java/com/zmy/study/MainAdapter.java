package com.zmy.study;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private List<String> mData;
    private Context mContext;
    private ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<String> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(mContext).inflate(R.layout.main_item, parent,false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i("haha", "2:"+mData.size());
        return mData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_content);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
