package cl.demo.rickandmortydemo.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.demo.rickandmortydemo.domain.model.Character
import cl.demo.rickandmortydemo.domain.model.Characters
import cl.demo.rickandmortydemo.domain.usecases.GetCharacterUseCase
import cl.demo.rickandmortydemo.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: GetCharactersUseCase,
    private val characterUseCase: GetCharacterUseCase
)  : ViewModel() {

    val charactersList = MutableLiveData<List<Characters>>()
    val character = MutableLiveData<Character>()
    val isLoading = MutableLiveData<Boolean>()
    val actualPage = MutableLiveData<Int>()
    val msgError = MutableLiveData<String>()
    private var page = 1

    fun getCharacters(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = charactersUseCase(page)
            if (result.data != null) {
                charactersList.postValue(result.data!!)
                isLoading.postValue(false)
            } else {
                msgError.postValue(result.message!!)
                isLoading.postValue(false)
            }
        }
    }

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = characterUseCase(id)
            if(result.data != null)     {
                character.postValue(result.data!!)
            }else {
                msgError.postValue(result.message!!)
            }
        }
    }

    fun movePage(pos: Int){
        page += pos
        actualPage.postValue(page)
        getCharacters()
    }

}