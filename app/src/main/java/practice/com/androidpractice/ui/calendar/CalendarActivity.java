package practice.com.androidpractice.ui.calendar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import practice.com.androidpractice.R;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        setContentView(new MeiZuMonthView(CalendarActivity.this));
        setContentView(R.layout.calendar);
    }
}
