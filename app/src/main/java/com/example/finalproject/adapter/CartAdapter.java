package com.example.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.CartActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.dto.GetCartResponse;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private CartActivity context;
    private int layout;
    private List<GetCartResponse> list;

    public CartAdapter(CartActivity context, int layout, List<GetCartResponse> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView courseImage = (ImageView) view.findViewById(R.id.img_course);
        TextView title = (TextView) view.findViewById(R.id.tv_title);
        TextView tvPrice = (TextView) view.findViewById(R.id.tv_totalPrice);
        CheckBox check = (CheckBox) view.findViewById(R.id.check_box_cart);

        GetCartResponse cart = list.get(i);
        title.setText(cart.getCourseId().getTitle());
        tvPrice.setText(cart.getCourseId().getPrice().toString());

        //Picasso.get().load(cart.getCourseId().getThumbnailUrl()).into(courseImage);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    if (context.listCartId.indexOf(cart.get_id()) != -1) {
                        return;
                    }
                    context.total += Double.valueOf(tvPrice.getText().toString());
                    context.updateTotal();
                    context.listCartId.add(cart.get_id());
                } else {
                    if (context.listCartId.indexOf(cart.get_id()) == -1) {
                        return;
                    }
                    context.total -= Integer.valueOf(tvPrice.getText().toString());
                    context.updateTotal();
                    context.listCartId.remove(cart.get_id());
                }
            }
        });

        return view;
    }
}
