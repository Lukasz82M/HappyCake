package de.syntaxinstitut.happycake.ui.firebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login_) {
    private lateinit var binding:FragmentLoginBinding

    private val viewModel:LoginViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            val email = binding.editTextUsername.text.toString()

            val password = binding.editTextPassword.text.toString()

            if (!email.isNullOrEmpty()&& !password.isNullOrEmpty()){
                viewModel.login(email, password)
            }
        }
        binding.SignUp.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }
}

