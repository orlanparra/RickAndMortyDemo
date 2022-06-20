package cl.demo.rickandmortydemo.domain.repository

import cl.demo.rickandmortydemo.data.Result
import cl.demo.rickandmortydemo.domain.model.Character
import cl.demo.rickandmortydemo.domain.model.Characters

interface CharacterRepository {

    suspend fun getCharacters(page: Int): Result<List<Characters>>
    suspend fun getCharacter(id: Int): Result<Character>
}