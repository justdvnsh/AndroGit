package divyansh.tech.androgit.features.onboarding.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.databinding.FragmentLoginBinding
import divyansh.tech.androgit.features.MainActivity
import divyansh.tech.androgit.features.onboarding.OnboardingActivity
import divyansh.tech.utility.C

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.oAuthButton.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(C.OAUTH_URL + "?client_id=" + C.CLIENT_ID)
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        val token = (activity as OnboardingActivity).intent.data

        if (token != null && token.toString().startsWith(C.OAUTH_REDIRECT_URL)) {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            Toast.makeText(
                requireContext(),
                token.getQueryParameter("code").toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}