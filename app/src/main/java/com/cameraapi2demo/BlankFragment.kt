package com.cameraapi2demo


import android.app.AppComponentFactory
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_blank.view.*

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    private var root : View? = null
    private var act : AppCompatActivity? = null

    companion object{
        @JvmStatic fun newInstance(): BlankFragment = BlankFragment()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        act = context as AppCompatActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_blank, container, false)

        root?.click?.setOnClickListener {
            (act as MainActivity).openCamera()
        }

        return root
    }


}
