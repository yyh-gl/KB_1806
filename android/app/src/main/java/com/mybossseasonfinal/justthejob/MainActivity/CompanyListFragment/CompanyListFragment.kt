package com.mybossseasonfinal.justthejob.MainActivity.CompanyListFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.mybossseasonfinal.justthejob.DI.Component.DaggerFragmentComponent
import com.mybossseasonfinal.justthejob.DI.Module.FragmentModule
import com.mybossseasonfinal.justthejob.JustTheJobApp
import com.mybossseasonfinal.justthejob.MainActivity.NavigationDrawerFragment.NavigationDrawerFragment
import com.mybossseasonfinal.justthejob.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CompanyListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CompanyListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CompanyListFragment : Fragment(), CompanyListFragmentContract.View {
    private var cnt = 0


    companion object {
        fun createInstance(count: Int): CompanyListFragment {
            val companyListFragment = CompanyListFragment()
            val args = Bundle()
            args.putInt("Counter", count)
            companyListFragment.arguments = args
            return companyListFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFragmentComponent.builder()
                .appComponent((activity?.applicationContext as JustTheJobApp).getComponent())
                .fragmentModule(FragmentModule(this))
                .build()
                .inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments

        if (args != null) {
            val count = args.getInt("Counter")
            val str = "CompanyListFragment$count"
            cnt = count + 1

            val textView = view.findViewById<TextView>(R.id.textview_02)
            textView.text = str
        }

        val button02 = view.findViewById<Button>(R.id.button_02)
        button02.setOnClickListener {
            val fragmentManager = fragmentManager
            if (fragmentManager != null) {
                val fragmentTransaction = fragmentManager.beginTransaction()

                //BackStackを設定
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.replace(R.id.navigationDrawerFragmentContainer, NavigationDrawerFragment.createInstance(cnt))
                fragmentTransaction.commit()
            }
        }

        //BackStackで一つ戻す
        val pop2 = view.findViewById<Button>(R.id.pop_02)
        pop2.setOnClickListener {
            val fragmentManager = fragmentManager
            if (fragmentManager != null) {
                fragmentManager.popBackStack()
            }
        }
    }
}