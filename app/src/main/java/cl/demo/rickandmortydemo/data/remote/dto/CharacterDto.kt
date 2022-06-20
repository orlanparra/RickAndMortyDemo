package cl.demo.rickandmortydemo.data.remote.dto


import cl.demo.rickandmortydemo.domain.model.Character
import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: LocationDto,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: OriginDto,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String
)
{
    fun toCharacter() : Character {
        return Character(
            id = id,
            name = name,
            gender = gender,
            status = status,
            species = species,
            image = image,
            location = location.toLocation(),
            origin = origin.toOrigin()
        )
    }
}