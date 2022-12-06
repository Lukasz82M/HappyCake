package de.syntaxinstitut.happycake.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.happycake.MainViewModel
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.databinding.FragmentFormularBinding
import de.syntaxinstitut.happycake.databinding.FragmentPaymentBinding


class PaymentFragment : Fragment() {
    private lateinit var binding: FragmentPaymentBinding
    private val viewmodel: MainViewModel by activityViewModels()





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_payment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonWeiterPayment.setOnClickListener { findNavController().navigate(PaymentFragmentDirections.actionPaymentFragmentToCheckOutFragment())}




        binding.spinnerPayment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val paymentspinner = requireContext().resources.getStringArray(R.array.Payment)
                    Log.d ("Payment","${paymentspinner[position]} wurde ausgewählt")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    //TODO("Not yet implemented")
                }

            }
    }

}