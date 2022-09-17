package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ActivityInformation;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.IMG;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class IMG_Adapter extends RecyclerView.Adapter<IMG_Adapter.IMGViewHolder> {
    private Context mContext;
    private ArrayList<IMG> lst_IMG;

    public IMG_Adapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setDataIMG(ArrayList<IMG> lst){
        this.lst_IMG = lst;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IMGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img,parent,false);
        return new IMGViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IMGViewHolder holder, int position) {
        IMG img = lst_IMG.get(position);
        if (img==null){
            return;
        }
        Picasso.with(mContext)
                .load(img.getUrl())
                .into(holder.img);
        holder.tv.setText(img.getId());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ActivityInformation.class);
                intent.putExtra("key_id",img.getId());
                mContext.startActivities(new Intent[]{intent});

            }
        });

    }

    @Override
    public int getItemCount() {
        if (lst_IMG!=null){
            return lst_IMG.size();
        }
        return 0;
    }

    public class IMGViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView tv;

        public IMGViewHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.img_item_img);
            tv = itemView.findViewById(R.id.tv_item_img);

        }
    }
}
