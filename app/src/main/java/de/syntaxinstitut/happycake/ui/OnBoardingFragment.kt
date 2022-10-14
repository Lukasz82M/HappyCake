package de.syntaxinstitut.happycake.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.databinding.FragmentOnBoardingBinding


/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding,container, false)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToLoginFragment())
        },6000)
            return  binding.root
    }

}