package practice.com.androidpractice.network.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.util.Log;

public class ConnectivityServiceTest {

    private static ConnectivityManager connectivityManager;
    private static final  Object object = new Object();
    private static final String TAG = ConnectivityServiceTest.class.getSimpleName();

    private ConnectivityServiceTest() {

    }

    public static void listenNetwork(Context context) {
        MyNetworkCallback networkCallback = new MyNetworkCallback();
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        NetworkRequest request = builder.build();
        if (connectivityManager == null) {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        connectivityManager.registerNetworkCallback(request, networkCallback);
    }

    public static class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        @Override
        public void onAvailable(Network network) {
            super.onAvailable(network);
            Log.d(TAG, "onAvailable: 网络已连接");
        }

        @Override
        public void onLost(Network network) {
            super.onLost(network);
            Log.e(TAG, "onLost: 网络已断开");
        }

        @Override
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
                if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.d(TAG, "onCapabilitiesChanged: 网络类型为wifi");
                } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.d(TAG, "onCapabilitiesChanged: 蜂窝网络");
                } else {
                    Log.d(TAG, "onCapabilitiesChanged: 其他网络");
                }
            }
        }
    }
}
