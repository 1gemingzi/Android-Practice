package practice.com.androidpractice.ui.recycleview;

import android.os.Bundle;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import practice.com.androidpractice.R;

public class RecycleviewActivity extends AppCompatActivity {

    private String[] data = {"one", "two", "three", "four", "five", "six"};

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.recycleview);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);


//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(new MyRecycleviewAdapter(data));
    }
}
