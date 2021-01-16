package com.ummi.infocovid_19.api

import com.ummi.infocovid_19.model.IndonesiaResponse
import com.ummi.infocovid_19.model.ProvinceResponse
import retrofit2.http.GET
import retrofit2.Call

interface Api {
    @GET ("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET ("indonesia/provinsi")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}