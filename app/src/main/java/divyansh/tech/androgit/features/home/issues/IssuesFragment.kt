package divyansh.tech.androgit.features.home.issues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.databinding.FragmentIssuesBinding
import javax.inject.Inject

@AndroidEntryPoint
class IssuesFragment: Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private val issuesAdapter by lazy { IssuesAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabsAndViewPager()
    }

    private fun setupTabsAndViewPager() {
        binding.issuesPager.adapter = issuesAdapter
        TabLayoutMediator(binding.tabLayout, binding.issuesPager) {tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.all_issues)
                1 -> tab.text = getString(R.string.assigned_issues)
                2 -> tab.text = getString(R.string.created_issues)
                3 -> tab.text = getString(R.string.mentioned_issues)
                4 -> tab.text = getString(R.string.subscribed_issues)
            }
        }.attach()
    }

    override fun onPause() {
        super.onPause()
        binding.run {
            issuesPager.adapter = null
        }
    }
}