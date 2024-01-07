package practice.com.androidpractice.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import practice.com.androidpractice.R;


public class FragmentActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalFocusChangeListener {

    private EditText text1;
    private EditText text2;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.fragment_main);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        LinearLayout linearLayout = findViewById(R.id.screen);
        linearLayout.getViewTreeObserver().addOnGlobalFocusChangeListener(FragmentActivity.this);
    }

    @Override
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        Log.d("test", "focus changes");
        if (newFocus.equals(text1)) {
            replaceFragment(new MyFragment());
        } else if (newFocus.equals(text2)) {
            replaceFragment(new AnotherFragment());
        }
    }

    private void replaceFragment(Fragment fragment) {
        Log.i("test", "fragment button onclick");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fm = fragmentManager.beginTransaction();
        fm.replace(R.id.frameContent, fragment);
        fm.commit();
        Log.i("test", "fragment commit");
    }
}
