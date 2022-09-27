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

/**
 * Fragment 1
 */
class LoginFragment : Fragment(R.layout.fragment_login_) {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding:FragmentLoginBinding
// FEHLT NOCH WAS

    /** Das ViewModel zu diesem Fragment */
    private val viewModel:LoginViewModel by activityViewModels()

/* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode wenn das View erstellt wird
     *
     * @param inflater                Layout Inflater
     * @param container               View Gruppe
     * @param savedInstanceState      Eventuelle saveStates
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return binding.root
    }


    /**
     * Lifecycle Methode nachdem das View erstellt wurde
     *
     * @param view                    Das angezeigte View
     * @param savedInstanceState      Eventuelle saveStates
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* -------------------- UI-Interaktionen -------------------- */
        binding.loginButton.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            val email = binding.editTextUsername.text.toString()

            val password = binding.editTextPassword.text.toString()

            if (!email.isNullOrEmpty()&& !password.isNullOrEmpty()){
                viewModel.login(email, password)
            }
        }

        /* -------------------- Observer -------------------- */

        // Navigation zum zweiten Fragment
        binding.SignUp.setOnClickListener{
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }
}

