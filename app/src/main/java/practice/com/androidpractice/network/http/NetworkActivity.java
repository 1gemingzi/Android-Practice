package practice.com.androidpractice.network.http;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import practice.com.androidpractice.R;

public class NetworkActivity extends Activity {

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.network_activity);
        Button button = findViewById(R.id.httptest);
        final TextView textView = findViewById(R.id.httpText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String text = HttpURLConnectionTest.request();
                        Log.d("test", text.substring(0, 3));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(text);
                            }
                        });

                    }
                }).start();
            }
        });
    }
}
