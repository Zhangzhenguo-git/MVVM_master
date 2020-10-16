package com.pack.mvvm;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * @author Zhangzhenguo
 * @create 2020/10/16
 * @Email 18311371235@163.com
 * @Describe
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private List<String> mList;
    private MyHolder myHolder;
    MyonListener listener;
    private  LayoutInflater inflater;

    public MyAdapter(Context context,List<String> mList){
        this.context=context;
        this.mList=mList;
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView=LayoutInflater.from(this.context).inflate(R.layout.itemsssss,parent,false);
        return new MyHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        Glide.with(context).load(mList.get(position)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.imageView);

        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher);
        RequestOptions requestOptions = new RequestOptions().centerCrop()
                .priority(Priority.LOW)
                .skipMemoryCache(false)
                .dontAnimate()
                .apply(options)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

//            Glide.with(context)
//                    .load(mList.get(position))
//                    .apply(requestOptions)//占位图
////                .apply(RequestOptions.bitmapTransform(new GlideRoundTransform(image.getContext().getApplicationContext(), radius)))
////                .into(new SimpleTarget<Drawable>() {
////                    @Override
////                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
////                        image.setImageDrawable(resource);
////                    }
////                });
//                    .into(holder.imageView);
        holder.imageView.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_launcher));


        holder.textView.setText("测试问题"+position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ivItem);
            textView=itemView.findViewById(R.id.tvItem);
        }
    }

    public interface MyonListener{
        void onChanged(int position);
    }

    public void setOnClcik(MyonListener listener){
        this.listener=listener;
    }


}
