package practice.com.androidpractice.network.http;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import practice.com.androidpractice.R;
import practice.com.androidpractice.network.connectivity.ConnectivityServiceTest;

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

        Button button1 = findViewById(R.id.okhttptest);
        final TextView textView1 = findViewById(R.id.okhttpText);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String text = OkHttpTest.request();
                        Log.d("test", text.substring(0, 3));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView1.setText(text);
                            }
                        });

                    }
                }).start();
            }
        });

        Button button2 = findViewById(R.id.okhttptest1);
        final TextView textView2 = findViewById(R.id.okhttpText1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpTest.getNetData("http://www.baidu.com", new OkHttpTest.okCallback() {
                            @Override
                            public void onFaile(String s) {
                                final String error = s;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG);
                                    }
                                });
                            }

                            @Override
                            public void onSuccess(String s) {
                                final String text = s;
                                Log.d("test", text.substring(0, 3));
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        textView2.setText(text);
                                    }
                                });
                            }
                        });


                    }
                }).start();
            }
        });

        Button button3 = findViewById(R.id.networkrequest);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityServiceTest.listenNetwork(NetworkActivity.this);
            }
        });

    }
}
