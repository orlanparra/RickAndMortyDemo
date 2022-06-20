package cl.demo.rickandmortydemo.di

import cl.demo.rickandmortydemo.data.remote.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApi(@Named("apiUrl") apiUrl: String) : ApiClient {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    @Named("apiUrl")
    fun provideApiUrl() : String = "https://rickandmortyapi.com/api/"
}