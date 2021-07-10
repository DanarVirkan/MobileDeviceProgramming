package com.example.mobiledeviceprogramming.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledeviceprogramming.R
import com.example.mobiledeviceprogramming.databinding.ActivityDetailsBinding
import com.example.mobiledeviceprogramming.domain.Siaran
import com.example.mobiledeviceprogramming.utils.Constant.SIARAN
import com.example.mobiledeviceprogramming.utils.DataDummy
import com.example.mobiledeviceprogramming.utils.Mapper
import com.google.android.material.appbar.AppBarLayout
import java.lang.Math.abs

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val siaranObj = intent.getSerializableExtra(SIARAN) as Siaran
        binding.posterDetail.setImageResource(siaranObj.cover)
        binding.judulDetail.text = siaranObj.judul
        var res = R.drawable.movie
        if (siaranObj.tipe == "TV") {
            res = R.drawable.tv
        }
        binding.tipeDetail.setImageResource(res)
        binding.genreDetail.text = siaranObj.genre
        val jamTayang = DataDummy.getJamTayang(siaranObj.idSiaran)
        val mappedJamTayang = Mapper.mapJamTayang(jamTayang[0])
        binding.hariTayang.text = mappedJamTayang[0].toString()
        binding.jamTayang.text = mappedJamTayang[1].toString()
        binding.synopsisDetail.text = siaranObj.synopsis
        binding.ratingDetail.text = siaranObj.rating

        binding.appBarDetail.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                binding.toolbarDetail.title = siaranObj.judul
            } else {
                binding.toolbarDetail.title = " "
            }
        })
        binding.toolbarDetail.title = siaranObj.judul

        binding.editDetail.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            intent.putExtra(SIARAN, siaranObj)
            startActivity(intent)
        }
    }
}