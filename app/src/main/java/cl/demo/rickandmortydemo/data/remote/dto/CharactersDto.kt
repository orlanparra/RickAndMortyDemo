package cl.demo.rickandmortydemo.data.remote.dto


import cl.demo.rickandmortydemo.domain.model.Characters
import com.google.gson.annotations.SerializedName

data class CharactersDto(
    @SerializedName("info")
    val info: InfoDto,
    @SerializedName("results")
    val results: List<ResultDto>
)
{
    fun toListCharacters() : List<Characters> {
        val mappedList = results.mapIndexed { _, item ->
            Characters(
                id = item.id,
                name = item.name,
                specie = item.species,
                image = item.image
            )
        }
        return mappedList
    }
}
