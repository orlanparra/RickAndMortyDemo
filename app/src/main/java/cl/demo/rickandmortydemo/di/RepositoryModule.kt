package cl.demo.rickandmortydemo.di

import cl.demo.rickandmortydemo.data.repository.CharacterRepositoryImpl
import cl.demo.rickandmortydemo.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl) : CharacterRepository
}