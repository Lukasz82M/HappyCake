package de.syntaxinstitut.happycake.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.load
import de.syntaxinstitut.happycake.MainViewModel
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.databinding.FragmentCakeDetailBinding
import de.syntaxinstitut.happycake.databinding.FragmentOnBoardingBinding
import de.syntaxinstitut.happycake.ui.firebase.LoginFragmentDirections


class CakeDetailFragment : Fragment() {
        private lateinit var binding: FragmentCakeDetailBinding
        private val viewmodel: MainViewModel by activityViewModels()
        private var cake_name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            arguments?.let {
                cake_name = it.getString("cake_name").toString()
            }

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cake_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailButton.setOnClickListener{
            findNavController().navigate(CakeDetailFragmentDirections.actionCakeDetailFragmentToFormularFragment())
        }

        viewmodel.cakes.observe(
            viewLifecycleOwner, Observer {
                list ->
                val cake = list.find { it.name == cake_name }
                if (cake != null){
                    binding.detailName.text = cake_name
                    binding.detailPrice.text = cake.price.toString()
                    val imgUri = cake.imageSrc.toUri().buildUpon().scheme("https").build()
                    binding.detailImg.load(imgUri)
                }
            }
        )
    }

}
