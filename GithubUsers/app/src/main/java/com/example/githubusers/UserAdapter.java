package com.example.githubusers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<User> users = new ArrayList<>();

    void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(i);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName, txtUserName, txtLocation, txtCompany;
        private CircleImageView imgCircle;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtUserName = view.findViewById(R.id.txt_username);
            txtLocation = view.findViewById(R.id.txt_location);
            txtCompany = view.findViewById(R.id.txt_company);
            imgCircle = view.findViewById(R.id.img_photo);
        }

        void bind(User user) {
            txtName.setText(user.getName());
            imgCircle.setImageResource(user.getPhoto());
            txtUserName.setText(user.getUserName());
            txtLocation.setText(user.getLocation());
            txtCompany.setText(user.getCompany());
        }
    }
}