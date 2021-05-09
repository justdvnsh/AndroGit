package divyansh.tech.androgit.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.features.home.feed.FeedFragment
import divyansh.tech.androgit.features.home.issues.IssuesFragment
import divyansh.tech.androgit.features.home.profile.ProfileFragment
import divyansh.tech.androgit.features.home.pull_requests.PullRequestsFragment
import divyansh.tech.androgit.features.onboarding.splash.SplashViewModel
import divyansh.tech.utility.ResultWrapper
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObserver()
    }

    /*
    * Function to call viewModel's function to get the Username of the user,
    * for further authentication calls !
    * */
    private fun setupObserver() {
        viewModel.user.observe(this, Observer {
            when (it) {
                is ResultWrapper.Error -> Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                is ResultWrapper.Success -> setupBottomBar()
                else -> {}
            }
        })
    }

    /*
    * Function to setup the Bottom bar and listener
    * */
    private fun setupBottomBar() {
        val navFragment = supportFragmentManager.findFragmentById(R.id.mainNavHost)
        NavigationUI.setupWithNavController(bottomNavigation, navFragment!!.findNavController())
        navFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.feedFragment -> bottomNavigation.visibility = View.VISIBLE
                R.id.issuesFragment -> bottomNavigation.visibility = View.VISIBLE
                R.id.pullRequestsFragment -> bottomNavigation.visibility = View.VISIBLE
                R.id.profileFragment -> bottomNavigation.visibility = View.VISIBLE
                else -> bottomNavigation.visibility = View.GONE
            }
        }
    }
}