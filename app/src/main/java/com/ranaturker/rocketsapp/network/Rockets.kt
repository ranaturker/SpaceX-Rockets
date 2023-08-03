package com.ranaturker.rocketsapp.network


import com.google.gson.annotations.SerializedName

data class Rockets(
    @SerializedName("active")
    val active: Boolean? = false,
    @SerializedName("company")
    val company: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("cost_per_launch")
    val costPerLaunch: Int? = 0,
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("first_flight")
    val firstFlight: String? = "",
    @SerializedName("flickr_images")
    val flickrImages: List<String>? = listOf(),
    @SerializedName("success_rate_pct")
    val successRatePct: Int? = 0,
    @SerializedName("wikipedia")
    val wikipedia: String? = ""
)