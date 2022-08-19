package com.example.breakingbadapp.screens.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.breakingbadapp.databinding.FragmentEpisodeListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EpisodeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EpisodeListFragment : Fragment() {

    private val viewModel: EpisodeViewModel by lazy {
        ViewModelProvider(this).get(EpisodeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentEpisodeListBinding.inflate(inflater)

        val adapter = EpisodeAdapter(
            EpisodeAdapter.OnClickListener {
                viewModel.displayPropertyDetails(it)
            }
        )
        binding.episodeList.adapter = adapter

        viewModel.navigateToSelectedProperty.observe(
            this,
            Observer {
                if (null != it) {
                    this.findNavController().navigate(EpisodeListFragmentDirections.actionEpisodeListFragmentToEpisodeDetailFragment(it))
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

        binding.lifecycleOwner = this

        binding.episodeViewModel = viewModel

        setHasOptionsMenu(true)

        return binding.root
    }
}
