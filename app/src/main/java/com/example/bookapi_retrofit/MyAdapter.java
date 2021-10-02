package com.example.bookapi_retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VHodr>{
    List<Itemss> ItemssList;
    Context context;
    private static int currentPosition = 0;

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
    public void onBindViewHolder(VHodr holder, @SuppressLint("RecyclerView") int position) {
        Itemss itemss=ItemssList.get(position);
        holder.t1.setText(itemss.getVolInfo().getTitle());
        String[] aut=itemss.getVolInfo().getAuthors();
        String authors="";
        for (int j=0;j< aut.length;j++)
            authors+=aut[j]+"\n";
        holder.t2.setText(authors);
        holder.t3.setText(itemss.getVolInfo().getDescription());
        Glide.with(context)
                .load(itemss.getVolInfo().getImagelinkss().getThumbnail())
                .into(holder.img);

        holder.linearLayout.setVisibility(View.GONE);
        if(currentPosition==position){
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return ItemssList.size();
    }


    public class VHodr extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView img;
        LinearLayout linearLayout;

        public VHodr(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textView);
            t2=itemView.findViewById(R.id.textView2);
            t3=itemView.findViewById(R.id.textView3);

            img=itemView.findViewById(R.id.imageView);

            linearLayout=itemView.findViewById(R.id.details);


        }
    }
}
