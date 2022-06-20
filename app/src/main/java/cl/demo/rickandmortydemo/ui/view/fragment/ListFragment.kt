package cl.demo.rickandmortydemo.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cl.demo.rickandmortydemo.R
import cl.demo.rickandmortydemo.databinding.FragmentListBinding
import cl.demo.rickandmortydemo.ui.recyclerview.CharactersAdapter
import cl.demo.rickandmortydemo.ui.viewmodel.CharactersViewModel
import cl.demo.rickandmortydemo.util.NEXT
import cl.demo.rickandmortydemo.util.PREVIOUS

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: CharactersViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        viewModel.getCharacters()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.characters)
        var adapter = CharactersAdapter()
        var layoutManager = LinearLayoutManager(requireContext())

        adapter.setMiOnClickListener(object : CharactersAdapter.MiOnClickListener{
            override fun onClickListener(id: Int) {
                viewModel.getCharacter(id)
                Navigation.findNavController(requireView()).navigate(R.id.action_listFragment_to_detailFragment)
            }
        })

        with(binding) {
            rvLista.adapter = adapter
            rvLista.layoutManager = layoutManager

            btnSiguiente.setOnClickListener {
                viewModel.movePage(NEXT)
            }

            btnAnterior.setOnClickListener {
                viewModel.movePage(PREVIOUS)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            with(binding) {
                progressBar.isVisible = it
                progressBar.bringToFront()
                btnSiguiente.isClickable = !it
                btnAnterior.isClickable = !it
            }
        })

        viewModel.charactersList.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        viewModel.actualPage.observe(viewLifecycleOwner, Observer {
            with(binding) {
                btnAnterior.isEnabled = it>1
                btnSiguiente.isEnabled = it<42
            }
        })

        viewModel.msgError.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })
    }
}