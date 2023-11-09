package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.ErolledCourseActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.dto.GetEnrolledCourseRespone;
import com.squareup.picasso.Picasso;


import java.util.List;

public class EnrolledCourseAdapter extends BaseAdapter {
    private ErolledCourseActivity context;
    private int layout;
    private List<GetEnrolledCourseRespone> list;

    public EnrolledCourseAdapter(ErolledCourseActivity context, int layout, List<GetEnrolledCourseRespone> list) {
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
        ImageView img = convertView.findViewById(R.id.img_enrolled_course_item);
        TextView title = convertView.findViewById(R.id.title_enrolled_course_item);

        GetEnrolledCourseRespone respone = list.get(position);

        String imageUrl = respone.getCourseId().getThumbnailUrl();
        Picasso.get().load(imageUrl).into(img);
        title.setText(respone.getCourseId().getTitle());
        return convertView;
    }
}
