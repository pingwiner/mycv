package com.myresume.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationDrawerAdapter extends ArrayAdapter<String> {
    private String[] mItems;
    private Context mContext;

    private int[] mIcons = new int[] {
            R.drawable.ic_menu_friendslist,
            R.drawable.ic_menu_manage,
            R.drawable.ic_menu_myplaces,
            R.drawable.ic_menu_edit,
            R.drawable.ic_menu_emoticons
    };

    public NavigationDrawerAdapter(Context context) {
        super(context, R.layout.navigation_drawer_item);
        mContext = context;
        mItems = context.getResources().getStringArray(R.array.navigation_drawer_items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = null;
        if (convertView == null) {
            rowView = inflater.inflate(R.layout.navigation_drawer_item, parent, false);
        } else {
            rowView = convertView;
        }
        ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
        TextView text = (TextView) rowView.findViewById(R.id.text);
        text.setText(mItems[position]);
        icon.setImageResource(mIcons[position]);
        return rowView;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

}
