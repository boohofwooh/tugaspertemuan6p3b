package com.example.tugaspertemuan6p3b

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tugaspertemuan6p3b.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val keterangan = arrayOf("Hadir Tepat Waktu", "Sakit", "Terlambat", "Izin")
        var selectedTime = ""
        var selectedDate = ""

        with(binding){
            val adapterKeterangan = ArrayAdapter<String>(this@MainActivity, R.layout.simple_spinner_item, keterangan)
            spinnerKeterangan.adapter= adapterKeterangan

            spinnerKeterangan.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        if(parent.getItemAtPosition(position).toString() == "Hadir Tepat Waktu"){
                            deskripsi.visibility = View.INVISIBLE
                        } else {
                            deskripsi.visibility = View.VISIBLE
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }
            timePicker.setOnTimeChangedListener { _, hourofDay, minute ->
                selectedTime = "$hourofDay:$minute"
            }

            datePicker2.init(
                datePicker2.year,
                datePicker2.month,
                datePicker2.dayOfMonth
            ){_, year, month, dayofMonth ->
                var thisMonth = ""
                if(month == 0){
                    thisMonth = "Januari"
                } else if(month == 1){
                    thisMonth = "Februari"
                } else if(month == 2){
                    thisMonth = "Maret"
                } else if(month == 3){
                    thisMonth = "April"
                } else if(month == 4){
                    thisMonth = "Mei"
                } else if(month == 5){
                    thisMonth = "Juni"
                } else if(month == 6){
                    thisMonth = "Juli"
                } else if(month == 7){
                    thisMonth = "Agustus"
                } else if(month == 8){
                    thisMonth = "September"
                } else if(month == 9){
                    thisMonth = "Oktober"
                } else if(month == 10){
                    thisMonth = "November"
                } else if(month == 11){
                    thisMonth = "Desember"
                }
                selectedDate = "$dayofMonth $thisMonth $year"
            }

            submitBtn.setOnClickListener {
                Toast.makeText(this@MainActivity,"Presensi berhasil $selectedDate jam $selectedTime",Toast.LENGTH_SHORT).show()
            }
        }
    }
}