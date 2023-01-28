package com.kundalik.chatter.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.firebase.auth.FirebaseAuth
import com.kundalik.chatter.MainActivity
import com.kundalik.chatter.R
import com.kundalik.chatter.databinding.ActivityPhoneNumberBinding

class PhoneNumberActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneNumberBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null ){
            startActivity(Intent(this@PhoneNumberActivity, MainActivity::class.java))
        }
        binding.btnContinue.setOnClickListener {
            if (binding.etNumber.text!!.isEmpty()) {
                Toast.makeText(this@PhoneNumberActivity, "Enter your Number", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this@PhoneNumberActivity, OTPActivity::class.java)
                intent.putExtra("number", binding.etNumber.text.toString())
                startActivity(intent)
            }

        }
    }
}