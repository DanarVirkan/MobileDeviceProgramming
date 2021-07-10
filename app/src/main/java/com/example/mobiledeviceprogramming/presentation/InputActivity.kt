package com.example.mobiledeviceprogramming.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobiledeviceprogramming.databinding.ActivityInputBinding
import com.example.mobiledeviceprogramming.domain.Siaran
import com.example.mobiledeviceprogramming.utils.Constant.SIARAN
import com.example.mobiledeviceprogramming.utils.Mapper.mapGenre

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private lateinit var alertDialog: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        alertDialog = AlertDialog.Builder(this)

        binding.posterInput.setOnClickListener {
            val intent = Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT)
            startActivityIfNeeded(intent, 1)
        }

        var tipe = "TV"
        val spinnerAdapter = TypeAdapter(this, arrayOf("TV", "Movie"))
        binding.tipeSpinnerInput.adapter = spinnerAdapter
        binding.tipeSpinnerInput.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    tipe = parent!!.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@InputActivity, "Nothing Selected", Toast.LENGTH_LONG).show()
                }

            }

        val siaranObj: Siaran? = intent.getSerializableExtra(SIARAN) as Siaran?
        if (siaranObj != null) {
            binding.posterInput.setImageResource(siaranObj.cover)
            binding.genreTextInput.text = siaranObj.genre
            binding.titleInput.editText?.setText(siaranObj.judul)
            binding.synopsisInput.editText?.setText(siaranObj.synopsis)
            tipe = siaranObj.tipe
            val selection = if (siaranObj.tipe == "TV") 0 else 1
            binding.tipeSpinnerInput.setSelection(selection)
        }


        val genre = arrayOf("Comedy", "Drama")
        val genreChecker = arrayOf(false, false)
        val checked = BooleanArray(genre.size)

        binding.setGenreInput.setOnClickListener {
            alertDialog.setTitle("Select Genre").setMultiChoiceItems(
                genre,
                checked
            ) { dialog, which, isChecked ->
                genreChecker[which] = isChecked
            }
                .setPositiveButton("Set") { dialog, _ ->
                    binding.genreTextInput.text = mapGenre(genre, genreChecker)
                    dialog.dismiss()
                }
                .setCancelable(false)
                .create().show()
        }
    }

    override fun onBackPressed() {
        alertDialog.setTitle("Discard Changes?")
            .setMessage("If you click OK changes would be discarded")
            .setPositiveButton("OK") { _, _ ->
                finish()
            }.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }.setCancelable(false).create().show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode != 0) {
            val path = data?.data
            binding.posterInput.setImageURI(path)
        }
    }
}