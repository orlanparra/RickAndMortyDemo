package cl.demo.rickandmortydemo.domain.usecases

import cl.demo.rickandmortydemo.data.Result
import cl.demo.rickandmortydemo.domain.model.Characters
import cl.demo.rickandmortydemo.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(page: Int): Result<List<Characters>> {
        return repository.getCharacters(page)
    }
}