package com.example.praktikumandroid_auliaindah17630254.ui.jenisbarang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.praktikumandroid_auliaindah17630254.R
import com.example.praktikumandroid_auliaindah17630254.databinding.ActivityJenisbarangPostBinding
import com.example.praktikumandroid_auliaindah17630254.model.JenisbarangData

class JenisbarangPostActivity : AppCompatActivity() {

    //aulia indah novianti putri_17630254

    private lateinit var binding: ActivityJenisbarangPostBinding
    private val viewModel: JenisbarangViewModel by lazy {
        ViewModelProvider(this).get(JenisbarangViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJenisbarangPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBarJenisbarangPost.visibility = View.INVISIBLE
        binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
        binding.btSimpanJenisbarangPost.setOnClickListener{

            val idJenisbarang = binding.etIdJenisbarang.text.toString()
            val namaJenisBarang = binding.etNamajenisbarang.text.toString()
            val jenisBarangData = JenisbarangData(idJenisbarang,namaJenisBarang)
//aulia indah novianti putri_17630254
            binding.progressBarJenisbarangPost.visibility = View.VISIBLE
            binding.btSimpanJenisbarangPost.visibility = View.INVISIBLE
//aulia indah novianti putri_17630254
            viewModel.create(jenisBarangData)
            viewModel.createResponse.observe(this,{
                binding.progressBarJenisbarangPost.visibility = View.INVISIBLE
                binding.btSimpanJenisbarangPost.visibility = View.VISIBLE
                Toast.makeText(this, it.body()?.message,Toast.LENGTH_SHORT).show()
            })
        }
    }
}