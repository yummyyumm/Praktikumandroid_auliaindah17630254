package com.example.praktikumandroid_auliaindah17630254.ui.jenisbarang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikumandroid_auliaindah17630254.R
import com.example.praktikumandroid_auliaindah17630254.databinding.ActivityJenisbarangBinding
import com.example.praktikumandroid_auliaindah17630254.model.JenisbarangData

class JenisbarangActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJenisbarangBinding
    private val list = ArrayList<JenisbarangData>()
    private val viewModel: JenisbarangViewModel by lazy {
        ViewModelProvider(this).get(JenisbarangViewModel::class.java)
    }
    //aulia indah novianti putri_17630254
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisbarangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvJenisbarang.setHasFixedSize(true)

        binding.progressBarJenisbarang.visibility = View.VISIBLE

        getListJenisbarang()
//aulia indah novianti putri_17630254
        binding.btTambahJenisbarang.setOnClickListener{
            val intent = Intent(this, JenisbarangPostActivity::class.java)
            startActivity(intent)
        }

    }
    //aulia indah novianti putri_17630254
    private fun getListJenisbarang() {
        viewModel.response.observe(this, {
            binding.progressBarJenisbarang.visibility = View.INVISIBLE
            list.addAll(it.data)
            binding.rvJenisbarang.layoutManager = LinearLayoutManager(this)
            val listJenisbarangAdapter = ListJenisbarangAdapter(list)
            binding.rvJenisbarang.adapter = listJenisbarangAdapter
        })
    }
}