package com.example.bookapi_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VHodr>{
    List<Itemss> ItemssList;
    Context context;

    public MyAdapter(List<Itemss> c1,Context context) {
        this.ItemssList = c1;
        this.context=context;
    }

    @Override
    public VHodr onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.indivlist,parent,false);
        return new VHodr(v);
    }

    @Override
    public void onBindViewHolder(VHodr holder, int position) {
        Itemss itemss=ItemssList.get(position);
        holder.t1.setText(itemss.getVolInfo().getTitle());
        String[] aut=itemss.getVolInfo().getAuthors();
        String authors="";
        for (int j=0;j< aut.length;j++)
            authors+=aut[j]+"\n";
        holder.t2.setText(authors);
        Glide.with(context)
                .load(itemss.getVolInfo().getImagelinkss().getThumbnail())
                .into(holder.img);
    }


    @Override
    public int getItemCount() {
        return ItemssList.size();
    }

    public void setData(List<Itemss> values) {
        this.ItemssList.clear();
        this.ItemssList.addAll(values);
        notifyDataSetChanged();
    }

    public class VHodr extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView img;

        public VHodr(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t3=itemView.findViewById(R.id.textView3);

            img=itemView.findViewById(R.id.imageView);

        }
    }
}
