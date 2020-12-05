package com.example.newsapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapi.model.NewsArticle;
import com.example.newsapi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<NewsArticle> articles;

    public NewsAdapter(Context context, ArrayList<NewsArticle> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.tvName.setText(articles.get(position).getTitle());
        holder.tvDesCription.setText(articles.get(position).getDescription());
        holder.tvAuthor.setText(articles.get(position).getAuthor());
        Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.ivNews);

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(articles.get(position).getUrl()));
                context.startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvDesCription;
        TextView tvAuthor;
        ImageView ivNews;
        LinearLayout item;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvDesCription = itemView.findViewById(R.id.tvDesCription);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            ivNews = itemView.findViewById(R.id.ivNews);
            item = itemView.findViewById(R.id.item_ll);
        }
    }
}