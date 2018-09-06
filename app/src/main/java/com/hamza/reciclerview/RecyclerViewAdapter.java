package com.hamza.reciclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private Context context;
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();

    public RecyclerViewAdapter(Context context, ArrayList<String> mImageNames, ArrayList<String> mImages) {
        this.context = context;
        this.mImageNames = mImageNames;
        this.mImages = mImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: calles");

        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(holder.getAdapterPosition()));

                Intent intent = new Intent(context, GalleryLayout.class);
                intent.putExtra("image_url", mImages.get(holder.getAdapterPosition()));
                intent.putExtra("image_name", mImageNames.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
