package com.example.praktikumandroid_auliaindah17630254.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikumandroid_auliaindah17630254.R
import com.example.praktikumandroid_auliaindah17630254.databinding.ActivityUserBinding
import com.example.praktikumandroid_auliaindah17630254.model.UserData

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private val list = ArrayList<UserData>()
    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)

        binding.progressBarUser.visibility = View.VISIBLE

        getListUser()

    }

    private fun getListUser() {
        viewModel.response.observe(this, {
            binding.progressBarUser.visibility = View.INVISIBLE
            list.addAll(it.data)
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
            val listHeroAdapter = ListUserAdapter(list)
            binding.rvUsers.adapter = listHeroAdapter
        })
    }
}