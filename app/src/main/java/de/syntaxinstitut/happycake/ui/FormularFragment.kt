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
import de.syntaxinstitut.happycake.databinding.FragmentFormularBinding


class FormularFragment : Fragment() {
        private lateinit var binding: FragmentFormularBinding
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
            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_formular, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.weiter.setOnClickListener { findNavController().navigate(FormularFragmentDirections.actionFormularFragmentToPaymentFragment()) }

            viewmodel.cakes.observe(
                viewLifecycleOwner, Observer {
                        list ->
                    val cake = list.find { it.name == cake_name }
                    if (cake != null){
                        binding.radioButton2.buttonDrawable
                        binding.RadioButton.buttonDrawable
                        binding.weiter.isClickable

                    }
                }
            )
        }

    }
