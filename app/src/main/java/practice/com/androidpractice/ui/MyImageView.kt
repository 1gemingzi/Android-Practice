package practice.com.androidpractice.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatImageView

class MyImageView @JvmOverloads constructor(context: Context ,attrs: AttributeSet? = null,
                  defStyleAttr: Int = 0) :
    AppCompatImageView(context, attrs, defStyleAttr) {


    private var lastX = 0f
    private var lastY = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            lastX = event.rawX
            lastY = event.rawY
        } else if (event?.action == MotionEvent.ACTION_MOVE) {
            // 计算手指移动的距离
            val dx = event.rawX - lastX
            val dy = event.rawY - lastY
            // 更新 ImageView 的位置
            x += dx
            y += dy
            // 更新上次触摸的坐标
            lastX = event.rawX
            lastY = event.rawY
        } else if (event?.action == MotionEvent.ACTION_UP) {
            // Do nothing
        }
        Log.d("MyImageView", "onTouchEvent: ${event?.action}    ${event?.x}    ${event?.y}")
        return true
    }

}