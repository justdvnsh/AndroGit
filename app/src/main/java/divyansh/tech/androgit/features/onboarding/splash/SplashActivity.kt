package divyansh.tech.androgit.features.onboarding.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.features.MainActivity
import divyansh.tech.androgit.features.onboarding.OnboardingActivity
import divyansh.tech.androgit.features.onboarding.auth.LoginViewModel

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.isUserLoggedIn()
        viewModel.accessToken.observe(this, Observer {
            //TODO: Finish the Splash Activity
            if (it) startActivity(Intent(this, MainActivity::class.java))
            else startActivity(Intent(this, OnboardingActivity::class.java))
        })
    }
}