package com.example.breakingbadapp.screens.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.breakingbadapp.databinding.FragmentCharacterListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterListFragment : Fragment() {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCharacterListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val adapter = CharacterAdapter(
            CharacterAdapter.OnClickListener {
                viewModel.displayPropertyDetails(it)
            }
        )
        binding.characterList.adapter = adapter

        viewModel.navigateToSelectedProperty.observe(
            this,
            Observer {
                if (null != it) {
                    this.findNavController().navigate(CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment(it))
                    viewModel.displayPropertyDetailsComplete()
                }
            }
        )

        viewModel.properties.observe(
            viewLifecycleOwner,
            Observer {
                it?.let {
                    adapter.submitList(it)
                }
            }
        )

        binding.characterViewModel = viewModel

        setHasOptionsMenu(true)

        return binding.root
    }
}
