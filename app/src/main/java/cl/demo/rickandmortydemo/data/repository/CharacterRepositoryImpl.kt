package cl.demo.rickandmortydemo.data.repository

import cl.demo.rickandmortydemo.data.Result
import cl.demo.rickandmortydemo.data.remote.ApiClient
import cl.demo.rickandmortydemo.domain.model.Character
import cl.demo.rickandmortydemo.domain.model.Characters
import cl.demo.rickandmortydemo.domain.repository.CharacterRepository
import cl.demo.rickandmortydemo.util.ERROR_GENERAL
import cl.demo.rickandmortydemo.util.ERROR_SERVER
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: ApiClient
): CharacterRepository {

    override suspend fun getCharacters(page: Int): Result<List<Characters>> {
        val response = try {
            api.getCharacters(page)
        } catch (ex: HttpException) {
            return Result.Error(message = ERROR_GENERAL, data=null)
        } catch (ex: IOException) {
            return Result.Error(message = ERROR_SERVER, data=null)
        }
        return Result.Success(response.toListCharacters())
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        val response = try {
            api.getCharacter(id)
        } catch (ex: HttpException) {
            return Result.Error(message = ERROR_GENERAL, data=null)
        } catch (ex:Exception) {
            return Result.Error(message = ERROR_SERVER, data=null)
        }
        return Result.Success(response.toCharacter())
    }

}