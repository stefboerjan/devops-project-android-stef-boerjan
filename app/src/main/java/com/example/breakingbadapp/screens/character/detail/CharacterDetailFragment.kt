package com.example.breakingbadapp.screens.character.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.breakingbadapp.databinding.FragmentCharacterDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val application = requireNotNull(activity).application
        val binding = FragmentCharacterDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val characterProperty = CharacterDetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = CharacterDetailViewModelFactory(characterProperty, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterDetailViewModel::class.java)
        return binding.root
    }
}
