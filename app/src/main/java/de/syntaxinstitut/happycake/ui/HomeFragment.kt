package de.syntaxinstitut.happycake.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.adapter.CakeAdapter
import de.syntaxinstitut.happycake.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ViewModel by activityViewModels()

// wenn die View gebaut wird (ANFANG)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
//        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Referenz um unseren Adapter zubefüllen
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

  //    binding.recyclerViewProdukte.adapter = CakeAdapter()


    }

   /* private fun CakeAdapter(): CakeAdapter {

    }*/

}