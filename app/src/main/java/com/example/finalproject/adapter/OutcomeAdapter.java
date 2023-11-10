package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.finalproject.R;

import java.util.List;

public class OutcomeAdapter extends BaseAdapter {
    private CourseDetailActivity context;
    private int layout;
    private List<String> list;

    public OutcomeAdapter(CourseDetailActivity context, int layout, List<String> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        TextView tvOutcome = convertView.findViewById(R.id.tvOutcome);

        tvOutcome.setText(list.get(position) + "");
        return convertView;
    }
}
