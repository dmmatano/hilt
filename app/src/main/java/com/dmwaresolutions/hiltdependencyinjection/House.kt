package com.dmwaresolutions.hiltdependencyinjection

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Named

class House @Inject constructor(
    @Named("houseAlert") private val alertSystem: AlertSystem
) {
    private var saleValue = 500_000.0
    private var rentValue = 0.0
    private var address = "Av. Paulista"

    init {
        calcRentValue()
    }

    fun getAddress() = address
    fun setAddress(a: String){
        address = a
    }

    fun setSaleValue(saleValue: Double){
        this.saleValue = saleValue
        calcRentValue()
    }

    private fun calcRentValue(){
        rentValue = saleValue * 0.007 //0.005 a 0.008
    }

    fun getRentValue(): Double{
        return rentValue
    }

    fun alertPolice(){
        alertSystem.startAlerting()
    }


}