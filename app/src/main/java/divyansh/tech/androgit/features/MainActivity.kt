package divyansh.tech.androgit.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.features.onboarding.splash.SplashViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // TODO: Add navigation and Bottom Bar
    //TODO: Add Side Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}