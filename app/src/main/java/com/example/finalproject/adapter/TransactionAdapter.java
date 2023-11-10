package com.example.finalproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.TransactionActivity;
import com.example.finalproject.model.dto.GetTransactionRespone;

import java.util.List;

public class TransactionAdapter extends BaseAdapter {
    private TransactionActivity context;
    private int layout;
    private List<GetTransactionRespone> list;

    public TransactionAdapter(TransactionActivity context, int layout, List<GetTransactionRespone> list) {
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
        TextView coId = convertView.findViewById(R.id.course_id_transaction);
        TextView payment = convertView.findViewById(R.id.payment_course_transaction);
        TextView total = convertView.findViewById(R.id.total_course_transaction);

        GetTransactionRespone respone = list.get(position);

        coId.setText(respone.getCourseId().getTitle());
        payment.setText(String.valueOf(respone.getPayment()));
        total.setText(String.valueOf(respone.getTotal()));


        return convertView;
    }
}
