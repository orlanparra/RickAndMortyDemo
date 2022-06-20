package cl.demo.rickandmortydemo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import cl.demo.rickandmortydemo.R
import cl.demo.rickandmortydemo.databinding.ActivityMainBinding
import cl.demo.rickandmortydemo.ui.viewmodel.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactersViewModel by viewModels()
    lateinit var nav:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hostFragment = supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment
        nav = hostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,nav)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(nav,null)
    }
}