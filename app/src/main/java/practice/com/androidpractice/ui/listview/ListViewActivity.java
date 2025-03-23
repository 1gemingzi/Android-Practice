package practice.com.androidpractice.ui.listview;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import practice.com.androidpractice.R;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"one", "two", "three", "four", "five", "six"};

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.listview);
        ListView listView = findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListViewActivity.this, R.layout.listview_item,
                data);
        listView.setAdapter(arrayAdapter);

    }
}
