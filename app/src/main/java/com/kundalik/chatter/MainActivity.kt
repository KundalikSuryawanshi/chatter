package com.kundalik.chatter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.kundalik.chatter.adapter.ViewPagerAdapter
import com.kundalik.chatter.auth.PhoneNumberActivity
import com.kundalik.chatter.databinding.ActivityMainBinding
import com.kundalik.chatter.fragments.CallsFragment
import com.kundalik.chatter.fragments.ChatFragment
import com.kundalik.chatter.fragments.StatusFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallsFragment())

        val adapter = ViewPagerAdapter(this@MainActivity, supportFragmentManager, fragmentArrayList)

        binding.viewPager.adapter = adapter

        binding.tbLayout.setupWithViewPager(binding.viewPager)

        auth = FirebaseAuth.getInstance()

//        if (auth.currentUser == null ){
//            startActivity(Intent(this, PhoneNumberActivity::class.java))
//        }



    }
}