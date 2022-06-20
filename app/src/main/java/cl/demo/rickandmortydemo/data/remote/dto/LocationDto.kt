package cl.demo.rickandmortydemo.data.remote.dto

import cl.demo.rickandmortydemo.domain.model.Location
import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
){
    fun toLocation(): Location {
        return Location(
            name = name,
            url = url
        )
    }
}