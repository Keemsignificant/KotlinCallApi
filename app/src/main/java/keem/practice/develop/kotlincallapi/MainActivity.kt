package keem.practice.develop.kotlincallapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val mainFragment = DataFragment()

        supportFragmentManager.beginTransaction().replace(R.id.main_content, mainFragment).commit()

    }
}