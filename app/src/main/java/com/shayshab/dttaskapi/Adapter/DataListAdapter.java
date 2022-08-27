package com.shayshab.dttaskapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shayshab.dttaskapi.Model.DataModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.MyViewHolder> {

    Context context;
    List<DataModel.Offer> dataModelList;

    public DataListAdapter(Context context, List<DataModel.Offer> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout., parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Picasso.get().load(dataModelList.get(position).getThumbnail().getHires()).into(holder.imgMovie);
        holder.txtMovieName.setText(dataModelList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgMovie;
        TextView txtMovieName;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.im);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);

        }
    }
}
