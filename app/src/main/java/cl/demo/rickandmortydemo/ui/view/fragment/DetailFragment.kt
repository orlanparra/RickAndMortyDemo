package cl.demo.rickandmortydemo.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.demo.rickandmortydemo.R
import cl.demo.rickandmortydemo.databinding.FragmentDetailBinding
import cl.demo.rickandmortydemo.ui.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: CharactersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.character)
        viewModel.character.observe(viewLifecycleOwner, Observer {
            with(binding) {
                Picasso.get().load(it.image).into(ivImage)
                tvName.text = it.name
                tvStatus.text = it.status
                tvSpecie.text = it.species
                tvGender.text = it.gender
                tvLocation.text = it.location.name
                tvOrigin.text = it.origin.name
            }
        })
    }
}