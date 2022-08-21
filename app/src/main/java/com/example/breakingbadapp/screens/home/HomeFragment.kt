package com.example.breakingbadapp.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadapp.R
import com.example.breakingbadapp.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

//    private val homeViewModel: HomeViewModel by lazy {
//        ViewModelProvider(this).get(HomeViewModel::class.java)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        // val application = requireNotNull(this.activity).application

        // val dataSource = BreakingBadDatabase.getInstance(application).breakingBadDatabaseDao

        // val viewModelFactory = HomeViewModelFactory(dataSource, application)

        // homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.homeViewModel = homeViewModel

        binding.setLifecycleOwner(this)

//        val binding = FragmentHomeBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.homeViewModel = homeViewModel
//        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.getQuote()
    }
}
