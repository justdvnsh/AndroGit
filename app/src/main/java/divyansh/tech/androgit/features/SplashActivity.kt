package divyansh.tech.androgit.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import divyansh.tech.androgit.R
import divyansh.tech.androgit.features.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(
            Intent(this, OnboardingActivity::class.java)
        )
    }
}