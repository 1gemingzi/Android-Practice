package practice.com.androidpractice.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import practice.com.androidpractice.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_main);

        Button button = findViewById(R.id.fragment_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("test", "fragment button onclick");
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fm = fragmentManager.beginTransaction();
                fm.replace(R.id.frameContent, new AnotherFragment());
                fm.commit();
                Log.i("test", "fragment commit");
            }
        });
    }
}
