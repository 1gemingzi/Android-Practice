package practice.com.androidpractice.ui.viewpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import practice.com.androidpractice.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends Activity {

    List<Integer> goodlist = new ArrayList<>();
    List<ImageView> ivGoodList = new ArrayList<>();

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.viewpager_activity);
        ViewPager viewPager = findViewById(R.id.viewpager_test);

        goodlist.add(R.drawable.good1);
        goodlist.add(R.drawable.good2);
        goodlist.add(R.drawable.good3);

        for (Integer integer : goodlist) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(integer);
            ivGoodList.add(iv);
        }

        viewPager.setAdapter(new GoodAdapter(getApplicationContext(), ivGoodList));

    }


    class GoodAdapter extends PagerAdapter {
        List<ImageView> ivList;
        Context context;

        public GoodAdapter(Context context, List<ImageView> ivList) {
            this.context = context;
            this.ivList = ivList;
        }

        @Override
        public int getCount() {
            return ivList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public ImageView instantiateItem(ViewGroup container, int position) {
            ImageView imageView=ivList.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView imageView=(ImageView)object;
            container.removeView(imageView);
        }
    }
}
