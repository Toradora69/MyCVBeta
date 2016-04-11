package com.example.michael.mycvbeta.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.michael.mycvbeta.R;

/**
 * Created by Michael on 31-03-2016.
 */
public class CustomerSwipeAdapter extends PagerAdapter {
    private int[] image_resources = {R.drawable.clannad3, R.drawable.ftail2, R.drawable.tora1, R.drawable.kyoukai};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomerSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (LinearLayout) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.animeImageView);
        TextView textView = (TextView) item_view.findViewById(R.id.image_count);

        imageView.setImageResource(image_resources[position]);
        if (position == 0) {
            textView.setText("Clannad");
        } else if (position == 1) {
            textView.setText("Fairytail");
        } else if (position == 2) {
            textView.setText("Toradora");
        } else if (position == 3) {
            textView.setText("Kyoukai No Kanata");
        }else
        {
            textView.setText("Empty");
        }
        container.addView(item_view);
        return item_view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
