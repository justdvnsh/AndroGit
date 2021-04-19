package divyansh.tech.androgit.features.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.features.home.feed.FeedFragment
import divyansh.tech.androgit.features.home.issues.IssuesFragment
import divyansh.tech.androgit.features.home.profile.ProfileFragment
import divyansh.tech.androgit.features.home.pull_requests.PullRequestsFragment
import divyansh.tech.androgit.features.onboarding.splash.SplashViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var feedFragment: FeedFragment
    @Inject lateinit var issuesFragment: IssuesFragment
    @Inject lateinit var pullRequestsFragment: PullRequestsFragment
    @Inject lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(feedFragment)

        bottomNavigation?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.feedFragment -> setCurrentFragment(feedFragment)
                R.id.issuesFragment -> setCurrentFragment(issuesFragment)
                R.id.pullRequestsFragment -> setCurrentFragment(pullRequestsFragment)
                R.id.profileFragment -> setCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(frag: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainNavHost, frag)
            commit()
        }
}