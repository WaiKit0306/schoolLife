package com.example.schoollife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.schoollife.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private val URL: String ="http://10.0.2.2/dbconnectsMAD/register.php"
    lateinit var  binding : ActivityRegisterBinding

    var name: String? = ""
    var email: String? = ""
    var phoneNum : String? = ""
    var password: String? = ""
    var reenterPassword: String? =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
    }


    fun register(view: View?)
    {

        name = binding.editTxtName.text.toString()
        email = binding.editTxtEmail.text.toString()
        phoneNum = binding.editTxtPhone.text.toString()
        password = binding.editTxtPassword.text.toString()
        reenterPassword = binding.editTxtPassword2.text.toString()

        if(validationData(name!!, email!!,phoneNum!!,password!!,reenterPassword!!))
        {
            val stringRequest: StringRequest = object : StringRequest(
                Request.Method.POST, URL, Response.Listener { response ->
                    binding.testTxt.text = response.toString()
                    Log.d("Register", response)
                    if (response == "success") {
                        binding.testTxt.text = "Successfully registered."
                        binding.btnSignup.isClickable = false
                    } else if (response == "failure") {
                        binding.testTxt.text = "Something went wrong!"
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(
                        applicationContext,
                        error.toString().trim { it <= ' ' },
                        Toast.LENGTH_SHORT
                    ).show()
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String>? {
                    val data: MutableMap<String, String> = HashMap()
                    data["name"] = name!!
                    data["email"] = email!!
                    data["phoneNum"] = phoneNum!!
                    data["password"] = password!!
                    return data
                }
            }
            val requestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        }
        else
        {
            binding.testTxt.text = "Error Prompt "
        }
    }

    fun validationData(name:String , email:String , phone:String ,password:String , reenterPassword:String): Boolean
    {
        var flag = true
        if(name.isEmpty())
        {
            binding.editTxtName.error = "Empty Fiseld "
            flag = false
        }

        if(email.isEmpty())
        {
            binding.editTxtEmail.error = "Empty Field "
            flag = false
        }

        if(phone.isEmpty())
        {
            binding.editTxtPhone.error = "Empty Field "
            flag = false
        }

        //

        if(password.isEmpty())
        {
            binding.editTxtPassword.error = "Empty Field "
            flag = false
        }


        if( reenterPassword.isEmpty())
        {
            binding.editTxtPassword2.error = "Empty Field "
            flag = false
        }


        return flag




    }





}



