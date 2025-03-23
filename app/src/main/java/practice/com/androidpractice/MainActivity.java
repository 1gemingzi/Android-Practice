package practice.com.androidpractice;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import practice.com.androidpractice.network.http.NetworkActivity;
import practice.com.androidpractice.project.BookInfoActivity;
import practice.com.androidpractice.ui.calendar.CalendarActivity;
import practice.com.androidpractice.ui.dialog.DialogActivity;
import practice.com.androidpractice.ui.fragment.FragmentActivity;
import practice.com.androidpractice.ui.listview.ListViewActivity;
import practice.com.androidpractice.ui.recycleview.RecycleviewActivity;
import practice.com.androidpractice.ui.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_new);

        // 获取 NavController
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        // 绑定底部导航栏

        BottomNavigationView view = (BottomNavigationView) findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(view, navController);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                NavigationUI.onNavDestinationSelected(item, navController);
                return true;
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

}
