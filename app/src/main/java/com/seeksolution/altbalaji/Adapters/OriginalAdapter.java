package com.seeksolution.altbalaji.Adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.altbalaji.R;
import com.seeksolution.altbalaji.models.OriginalModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OriginalAdapter extends RecyclerView.Adapter<OriginalAdapter.MyView> {

    public Context context;

    public OriginalAdapter(Context context, ArrayList<OriginalModel> arrayList_2) {
        this.context = context;
        this.arrayList_2 = arrayList_2;
    }

    public ArrayList<OriginalModel> arrayList_2;

    @NonNull
    @Override
    public OriginalAdapter.MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending_list,parent,false);

        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OriginalAdapter.MyView holder, int position) {
        final int i=position;
    holder.imageView.setVisibility(View.GONE);
    holder.imageView_shimmer.setVisibility(View.VISIBLE);
    holder.shimmerFrameLayout.startShimmer();
        Picasso.get().load(Uri.parse(arrayList_2.get(i).getImages())).into(holder.imageView);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            holder.shimmerFrameLayout.stopShimmer();
            holder.imageView_shimmer.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);
        }
    },4000);
    }

    @Override
    public int getItemCount() {
        return arrayList_2.size();
    }

    public class MyView extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ImageView imageView_shimmer;
        public ShimmerFrameLayout shimmerFrameLayout;
        public MyView(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_trending_list);
            imageView_shimmer=itemView.findViewById(R.id.iv_simmer_imageview);
            shimmerFrameLayout=itemView.findViewById(R.id.facebook_shimmer_layout);
        }
    }
}
