package com.example.schoollife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.schoollife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        replaceFragement(homeFragment())
        binding.btmNavView.setOnItemSelectedListener {
        when(it.itemId)
        {
            R.id.nav_home->replaceFragement(homeFragment())
            R.id.nav_profile->replaceFragement(profileFragment())
            else->{

            }



        }
            true
        }
    }

    private fun replaceFragement(fragment : Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()


    }

}