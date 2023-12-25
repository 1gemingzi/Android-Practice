package practice.com.androidpractice.ui.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import practice.com.androidpractice.R;

public class RecycleviewActivity extends AppCompatActivity {

    private String[] data = {"one", "two", "three", "four", "five", "six"};

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recycleview);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyRecycleviewAdapter(data));
    }
}
