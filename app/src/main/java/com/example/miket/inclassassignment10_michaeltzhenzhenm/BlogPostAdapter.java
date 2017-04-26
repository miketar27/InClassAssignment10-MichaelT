package com.example.miket.inclassassignment10_michaeltzhenzhenm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BlogPostAdapter extends RecyclerView.Adapter<BlogPostAdapter.ViewHolder> {
    Context mContext;
    private ArrayList<BlogPost> mDataset;

    // Provide a suitable constructor (depends on the kind of dataset)
    public BlogPostAdapter(ArrayList<BlogPost> dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BlogPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.mTextView.setText(mDataset[position]);
        holder.mTitle.setText(mDataset.get(position).getTitle());
        holder.mTime.setText(mDataset.get(position).toReadableTime());
        holder.mBody.setText(mDataset.get(position).getBody());
        holder.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("A Blogpost", mDataset.get(holder.getAdapterPosition()));
                mContext.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTitle;
        public TextView mTime;
        public TextView mBody;

        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.title);
            mTime = (TextView) v.findViewById(R.id.time);
            mBody = (TextView) v.findViewById(R.id.body);
        }
    }
}