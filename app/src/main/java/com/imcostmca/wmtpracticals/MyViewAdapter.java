package com.imcostmca.wmtpracticals;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sdsmdg.tastytoast.TastyToast;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyViewAdapter extends RecyclerView.Adapter<MyViewAdapter.ViewDataHolder> {

    private Context ctx;
    private List<ListItem> listItems;

    public MyViewAdapter(Context ctx, List<ListItem> listItems) {
        this.ctx = ctx;
        this.listItems = listItems;
    }

    @Override
    public ViewDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.list_item, null);
        return new ViewDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewDataHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.txtName.setText(listItem.getName());
        Picasso.get().load(listItem.getImg()).into(holder.imgList);
        holder.txtnID.setText(listItem.getnID() + "");
        holder.txtCategory.setText(listItem.getCategory());
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewDataHolder extends RecyclerView.ViewHolder {
        TextView txtnID, txtName,txtCategory;
        ImageView imgList;
        RelativeLayout relativeLayout;

        public ViewDataHolder(View itemView) {
            super(itemView);
            txtnID = itemView.findViewById(R.id.txtnID);
            txtName = itemView.findViewById(R.id.name);
            imgList = itemView.findViewById(R.id.imgList);
            txtCategory=itemView.findViewById(R.id.category);
            relativeLayout = itemView.findViewById(R.id.relMainContent);
        }
    }
}