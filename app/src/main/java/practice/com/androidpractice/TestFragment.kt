package practice.com.androidpractice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import practice.com.androidpractice.network.http.NetworkActivity
import practice.com.androidpractice.project.BookInfoActivity
import practice.com.androidpractice.ui.calendar.CalendarActivity
import practice.com.androidpractice.ui.dialog.DialogActivity
import practice.com.androidpractice.ui.fragment.FragmentActivity
import practice.com.androidpractice.ui.listview.ListViewActivity
import practice.com.androidpractice.ui.recycleview.RecycleviewActivity
import practice.com.androidpractice.ui.viewpager.ViewPagerActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.activity_main, container, false)
        layout.findViewById<View>(R.id.button1)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button2)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button3)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button4)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button5)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button6)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button7)?.setOnClickListener(this)
        layout.findViewById<View>(R.id.button8)?.setOnClickListener(this)
        return layout
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button1 -> {
                val intent = Intent(getContext(), ListViewActivity::class.java)
                startActivity(intent)
            }
            R.id.button2 -> {
                val intent = Intent(getContext(), RecycleviewActivity::class.java)
                startActivity(intent)
            }
            R.id.button3 -> {
                val intent = Intent(getContext(), CalendarActivity::class.java)
                startActivity(intent)
            }
            R.id.button4 -> {
                val intent = Intent(getContext(), FragmentActivity::class.java)
                startActivity(intent)
            }
            R.id.button5 -> {
                val intent = Intent(getContext(), ViewPagerActivity::class.java)
                startActivity(intent)
            }
            R.id.button6 -> {
                val intent = Intent(getContext(), NetworkActivity::class.java)
                startActivity(intent)
            }
            R.id.button7 -> {
                val intent = Intent(getContext(), DialogActivity::class.java)
                startActivity(intent)
            }
            R.id.button8 -> {
                val intent = Intent(getContext(), BookInfoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}