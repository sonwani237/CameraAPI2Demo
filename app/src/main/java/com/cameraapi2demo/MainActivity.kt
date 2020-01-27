package com.cameraapi2demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, BlankFragment.newInstance())
            .commit()

    }

    fun openCamera(){
        supportFragmentManager.beginTransaction()
            .add(R.id.container, CameraFragment.newInstance())
            .commit()
    }

    fun viewPicPath(path: String){

        val fragment = BlankFragment.newInstance()

        val mBundle = Bundle()
        mBundle.putString("path", path)
        fragment.arguments = mBundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}
