package com.example.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Hero> heroes = new ArrayList<>();

    void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    HeroAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int i) {
        return heroes.get(i);
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

        Hero hero = (Hero) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;
        private CircleImageView imgCircle;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            // use this if wanting the rectangle image
            // imgPhoto = view.findViewById(R.id.img_photo);

            //use this if wanting the circle-framed image
            imgCircle = view.findViewById(R.id.img_photo);
        }

        void bind(Hero hero) {
            txtName.setText(hero.getName());
            txtDescription.setText(hero.getDescription());

            // use this if wanting the rectangle image
            //imgPhoto.setImageResource(hero.getPhoto());

            //use this if wanting the circle-framed image
            imgCircle.setImageResource(hero.getPhoto());
        }
    }
}