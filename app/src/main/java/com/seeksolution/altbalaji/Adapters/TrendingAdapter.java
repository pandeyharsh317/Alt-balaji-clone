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
import com.seeksolution.altbalaji.models.TrendingModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyView> {

    public Context context;
    public ArrayList<TrendingModel> arrayList;

    //ArrayList<TrendingModel> arrayList
    public TrendingAdapter(Context context,ArrayList<TrendingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending_list,parent,false);
        return new MyView(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
      holder.imageView.setVisibility(View.GONE);
      holder.imageView_shimmer.setVisibility(View.VISIBLE);
      holder.shimmerFrameLayout.startShimmer();
        Picasso.get().load(Uri.parse(arrayList.get(position).getImageUrls())).into(holder.imageView);
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
        return arrayList.size();
    }
    public class MyView extends RecyclerView.ViewHolder{
        public ShimmerFrameLayout shimmerFrameLayout;
        public ImageView imageView_shimmer;
        public ImageView imageView;
        public MyView(@NonNull View itemView) {
            super(itemView);
            imageView_shimmer=itemView.findViewById(R.id.iv_simmer_imageview);
            shimmerFrameLayout=itemView.findViewById(R.id.facebook_shimmer_layout);
            imageView = itemView.findViewById(R.id.iv_trending_list);


        }
    }
}
