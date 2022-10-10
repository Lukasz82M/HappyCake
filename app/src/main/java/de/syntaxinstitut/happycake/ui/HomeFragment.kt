package de.syntaxinstitut.happycake.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import de.syntaxinstitut.happycake.MainActivity
import de.syntaxinstitut.happycake.MainViewModel
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.adapter.CakeAdapter
import de.syntaxinstitut.happycake.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()

// wenn die View gebaut wird (ANFANG)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    //(activity as MainActivity).showToolbar()

    // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

   // binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

    return binding.root
    }

    // Referenz um unseren Adapter zubefüllen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        viewModel.cakes.observe(
                viewLifecycleOwner,

            ){
        binding.recyclerViewProdukte.adapter = CakeAdapter(it)

        }

    }


}