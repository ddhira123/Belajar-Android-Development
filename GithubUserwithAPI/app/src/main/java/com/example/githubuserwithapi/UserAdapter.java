package com.example.githubuserwithapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<User> mData = new ArrayList<>();

    public void setData(ArrayList<User> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_user, viewGroup, false);
        return new UserViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgPhoto;
        TextView tv_name, tv_uname, tv_company, tv_location;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_uname = itemView.findViewById(R.id.txt_username);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }

        public void bind(User user) {
            tv_uname.setText(user.getUserName());
            Glide.with(itemView.getContext()).load(user.getPhoto()).into(imgPhoto);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickCallback.onItemClicked(mData.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(User data);
    }
}
