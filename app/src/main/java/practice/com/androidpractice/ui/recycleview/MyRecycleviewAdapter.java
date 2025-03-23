package practice.com.androidpractice.ui.recycleview;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import practice.com.androidpractice.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.ViewHolder> {
    List<String> list;
    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View v){
            super(v);
            this.textView = v.findViewById(R.id.text);
        }
    }

    public MyRecycleviewAdapter(String[] data) {
        list = new ArrayList<>(Arrays.asList(data));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("test", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i("test", "onBindViewHolder");
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
