package cl.demo.rickandmortydemo.remote

import cl.demo.rickandmortydemo.data.repository.CharacterRepositoryImpl
import cl.demo.rickandmortydemo.data.server.fromJson
import cl.demo.rickandmortydemo.di.ApiModule
import com.google.common.truth.Truth
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

//@UninstallModules(ApiModule::class)
@HiltAndroidTest
class RemoteInstumentationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    lateinit var server: MockWebServer

    @Inject
    lateinit var characterRepositoryImpl: CharacterRepositoryImpl

    @Before
    fun setUp() {
        hiltRule.inject()
        server = MockWebServer()
        server.start(8080)
        server.url("character/1")
        server.enqueue(
            MockResponse().fromJson("rick_and_morty_api.json")
        )
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun testServerSuccess() = runTest {
        val characters = characterRepositoryImpl.getCharacters(1)
        Truth.assertThat(characters.data?.get(0)?.name).isEqualTo("Rick Sanchez")
    }
}
