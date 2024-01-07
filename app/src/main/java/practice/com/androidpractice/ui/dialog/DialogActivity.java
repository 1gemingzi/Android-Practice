package practice.com.androidpractice.ui.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import practice.com.androidpractice.R;

public class DialogActivity extends Activity {

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_activity);
        Button button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(DialogActivity.this).setTitle("test").setMessage("this is a dialog")
                        .setCancelable(false)
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("test", "nono");
                                Toast.makeText(DialogActivity.this, "hahaha", Toast.LENGTH_LONG);
                            }
                        })
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("test", "yesyes");
                                Toast.makeText(DialogActivity.this, "yeyeye", Toast.LENGTH_LONG);
                            }
                        })
                        .setNeutralButton("middle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("test", "middle");
                            }
                        })
                        .show();
            }
        });
    }
}
