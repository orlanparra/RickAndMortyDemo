package cl.demo.rickandmortydemo.data.remote.dto


import cl.demo.rickandmortydemo.domain.model.Origin
import com.google.gson.annotations.SerializedName

data class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
){
    fun toOrigin() : Origin {
        return Origin(
            name = name,
            url = url
        )
    }
}