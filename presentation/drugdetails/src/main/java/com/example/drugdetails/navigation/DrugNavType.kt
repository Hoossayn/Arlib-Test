package com.example.drugdetails.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.example.core.network.model.response.Drug
import com.google.gson.Gson

object DrugNavType : NavType<Drug>(isNullableAllowed = false) {
    override fun put(bundle: Bundle, key: String, value: Drug) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Drug {
        return bundle.getParcelable(key)!!
    }

    override fun parseValue(value: String): Drug {
        return Gson().fromJson(value, Drug::class.java)
    }
}