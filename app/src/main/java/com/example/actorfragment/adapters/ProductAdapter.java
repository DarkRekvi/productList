package com.example.actorfragment.adapters;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actorfragment.R;
import com.example.actorfragment.entities.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<Product> products;

    public ProductAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);

        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Product product = products.get(position);

        viewHolder.nameView.setText(product.getName());
        viewHolder.typeView.setText(product.getType());
        viewHolder.companyView.setText(product.getCompany());

        return convertView;
    }

    private class ViewHolder {
        final TextView nameView, typeView, companyView;
        ViewHolder(View view){
            nameView = view.findViewById(R.id.item_list_photo);
            typeView = view.findViewById(R.id.item_list_full_name);
            companyView = view.findViewById(R.id.item_list_date_of_born);
        }
    }
}
