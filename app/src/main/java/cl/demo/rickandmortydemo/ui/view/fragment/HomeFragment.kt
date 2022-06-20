package cl.demo.rickandmortydemo.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import cl.demo.rickandmortydemo.R
import cl.demo.rickandmortydemo.databinding.FragmentHomeBinding
import cl.demo.rickandmortydemo.ui.viewmodel.CharactersViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel:CharactersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
        with(binding) {
            brnIngresar.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_listFragment)
            }
        }
    }
}