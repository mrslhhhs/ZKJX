package com.zkjx.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zkjx.myapplication.R;
import com.zkjx.myapplication.view.AdImageViewVersion1;

import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {
    /**
     * 配合AdImageViewVersion1使用
     */
    Context context;
    List<String> mockDatas;
    public CommonAdapter(Context context ,List<String> mockDatas){
        this.context=context;

        this.mockDatas=mockDatas;
    }
    @NonNull
    @Override
    public CommonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item,null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonAdapter.ViewHolder viewHolder, int position) {
        if (position>0&&position%7==0){

            viewHolder.id_iv_ad.setVisibility(View.VISIBLE);
            viewHolder.id_tv_title.setVisibility(View.VISIBLE);
            viewHolder.id_tv_desc.setVisibility(View.GONE);
        }else {
            viewHolder.id_iv_ad.setVisibility(View.GONE);
            viewHolder.id_tv_title.setVisibility(View.GONE);
            viewHolder.id_tv_desc.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return mockDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AdImageViewVersion1 id_iv_ad;
        TextView id_tv_title;
        TextView id_tv_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_iv_ad=itemView.findViewById(R.id.id_iv_ad);
            id_tv_title=itemView.findViewById(R.id.id_tv_title);
            id_tv_desc=itemView.findViewById(R.id.id_tv_desc);
        }
    }
}
