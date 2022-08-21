package com.example.breakingbadapp.screens.episode.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadapp.databinding.FragmentEpisodeDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EpisodeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EpisodeDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val application = requireNotNull(activity).application
        val binding = FragmentEpisodeDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val episodeProperty = EpisodeDetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = EpisodeDetailViewModelFactory(episodeProperty, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(EpisodeDetailViewModel::class.java)
        return binding.root
    }
}
