package com.seeksolution.altbalaji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.seeksolution.altbalaji.Adapters.OriginalAdapter;
import com.seeksolution.altbalaji.Adapters.TrendingAdapter;
import com.seeksolution.altbalaji.models.OriginalModel;
import com.seeksolution.altbalaji.models.TrendingModel;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private String[] ImageUrls = {
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1208/1431208-v-895cd0d6b37f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
    };
    private String[] ImageUrls1={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1208/1431208-v-895cd0d6b37f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
    };

    ArrayList<TrendingModel> modelArrayList=new ArrayList<TrendingModel>();
    ArrayList<OriginalModel> originalModels_arr=new ArrayList<OriginalModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rc_view_trending_list);
        recyclerView1=(RecyclerView) findViewById(R.id.rc_view_trending_list_2);
        //Layout manager => Horizontal


//first
            for(int i=0;i<ImageUrls.length;i++){
                modelArrayList.add(new TrendingModel(ImageUrls[i]));
            }


            TrendingAdapter adapter = new TrendingAdapter(getApplicationContext(),modelArrayList);

            recyclerView.setLayoutManager( new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false) );
            recyclerView.setAdapter(adapter);
//second
//        for (int i=0;i<ImageUrls1.length;i++){
//            originalModels_arr.add(new OriginalModel(ImageUrls1[i]));
//        }
//
//        OriginalAdapter adapter1=new OriginalAdapter(getApplicationContext(),originalModels_arr);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
//        recyclerView1.setAdapter(adapter1);


        for(int i=0;i<ImageUrls1.length;i++){
            modelArrayList.add(new TrendingModel(ImageUrls1[i]));
        }


        ArrayList<TrendingModel> TrendingAdapter = new ArrayList<>();
        TrendingAdapter adapter1 = new TrendingAdapter(getApplicationContext(),TrendingAdapter);

        recyclerView1.setLayoutManager( new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false) );
        recyclerView1.setAdapter(adapter1);


    }

}