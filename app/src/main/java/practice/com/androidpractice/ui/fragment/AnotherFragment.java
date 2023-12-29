package practice.com.androidpractice.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import practice.com.androidpractice.R;

public class AnotherFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("test", "onCreateView");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.anotherfragment, container, false);
        return view;
    }
}
