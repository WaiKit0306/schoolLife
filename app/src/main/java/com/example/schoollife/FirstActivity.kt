package com.example.schoollife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.schoollife.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_first)


        //Redirect Button
        binding.btnLogin.setOnClickListener{loginBut()}
        binding.btnSignup.setOnClickListener{registerBut()}



    }

    private fun loginBut()
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private fun registerBut()
    {
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

}