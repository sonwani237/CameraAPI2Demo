package com.cameraapi2demo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_blank.view.*
import java.io.ByteArrayOutputStream
import java.io.File

/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    private var root : View? = null
    private var mPath : String? = null
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

        mPath = arguments?.getString("path").toString()

        if (!mPath.isNullOrEmpty()){
            root!!.path.text = encodeToBase64(mPath!!)
        }

        root!!.click.setOnClickListener {
            (act as MainActivity).openCamera()
        }

        return root
    }

    private fun encodeToBase64(filePath: String):String {
        val imgFile = File(filePath)
        return if (imgFile.exists() && imgFile.length() > 0) {
            val bm = BitmapFactory.decodeFile(filePath)
            val bOut = ByteArrayOutputStream()
            bm.compress(Bitmap.CompressFormat.JPEG, 100, bOut)
            Base64.encodeToString(bOut.toByteArray(), Base64.DEFAULT)
        }else{
            ""
        }
    }


}
