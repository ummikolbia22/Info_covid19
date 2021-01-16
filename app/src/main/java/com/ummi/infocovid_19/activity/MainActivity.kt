package com.ummi.infocovid_19.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ummi.infocovid_19.R
import com.ummi.infocovid_19.api.RetrofitClient
import com.ummi.infocovid_19.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()

        btnProvince.setOnClickListener {
            val intent = Intent(this, ProvinceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val indonesia = response.body()?.get(0)
                val positive = indonesia?.positif
                val hospitalized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text = positive
                tvHospitalized.text = hospitalized
                tvRecover.text = recover
                tvDeath.text = death
            }

        })
    }
}