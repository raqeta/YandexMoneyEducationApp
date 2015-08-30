package ru.yandex.money.education.app.components.view.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ru.yandex.money.education.app.R;

public class AdapterEdu extends BaseAdapter {

    private final List<String> data;
    private final LayoutInflater inflater;

    public AdapterEdu(Context context, List<String> data) {
        if (context == null) {
            throw new NullPointerException("context is null");
        }
        if (data == null) {
            throw new NullPointerException("data is null");
        }
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView == null ?
                inflater.inflate(R.layout.item_edu, parent, false) :
                convertView;
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.build(getItem(position));
        return view;
    }

    private static class ViewHolder {

        private TextView label;

        public ViewHolder(View view) {
            label = (TextView) view.findViewById(R.id.label);
        }

        public void build(String data) {
            label.setText(data);
        }
    }
}
