package com.example.cvapp.common

import com.example.cvapp.data.model.Location

object Utils {

    fun getAddressFromLocation(location: Location) :String {

        return StringBuilder().append(location.address)
            .append("\n")
            .append(location.city)
            .append(", ")
            .append(location.postalCode)
            .append("\n")
            .append(location.region)
            .append(", ")
            .append(location.countryCode).toString()
    }
}