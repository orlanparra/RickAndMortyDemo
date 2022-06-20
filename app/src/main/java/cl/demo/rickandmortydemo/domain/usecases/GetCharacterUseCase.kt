package cl.demo.rickandmortydemo.domain.usecases

import cl.demo.rickandmortydemo.data.Result
import cl.demo.rickandmortydemo.domain.model.Character
import cl.demo.rickandmortydemo.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: Int): Result<Character> {
        return repository.getCharacter(id)
    }
}