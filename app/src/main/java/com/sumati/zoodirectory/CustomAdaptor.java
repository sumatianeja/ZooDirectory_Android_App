package com.sumati.zoodirectory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by sumati on 1/30/16.
 */
public class CustomAdaptor extends ArrayAdapter<Animal> {

    private final List<Animal> animals;

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    public CustomAdaptor(Context context, int resource, List<Animal> animals){
        super(context, resource, animals);
        this.animals = animals;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = animals.get(position);

        View row;
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.rowImage);
            holder.textView = (TextView) row.findViewById(R.id.rowText);
            row.setTag(holder);
        } else {
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        // Set the text
        holder.textView.setText(animal.getName());

        // Set the image
        try {
            InputStream inputStream = getContext().getAssets().open(animal.getFilename());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;

    }
}
