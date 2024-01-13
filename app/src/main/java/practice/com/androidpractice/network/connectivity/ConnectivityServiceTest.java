package practice.com.androidpractice.network.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConnectivityServiceTest {

    private ConnectivityManager connectivityManager;
    private static final  Object object = new Object();

    private ConnectivityServiceTest() {

    }

    public ConnectivityManager getInstance(Context context) {
        synchronized (object) {
            if (connectivityManager == null) {
                synchronized (object) {
                    connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                }
            }
        }
        return connectivityManager;
    }
}
