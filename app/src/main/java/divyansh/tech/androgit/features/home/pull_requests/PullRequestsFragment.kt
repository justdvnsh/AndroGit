package divyansh.tech.androgit.features.home.pull_requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.databinding.FragmentPullRequestsBinding
import javax.inject.Inject

@AndroidEntryPoint
class PullRequestsFragment: Fragment() {

    private lateinit var binding: FragmentPullRequestsBinding
    private val prAdapter by lazy { PrAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPullRequestsBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    /*Helper method to setup the adapter*/
    private fun setupAdapter() {
        binding.prPager.adapter = prAdapter
        TabLayoutMediator(binding.tabLayoutPr, binding.prPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.created)
                1 -> tab.text = getString(R.string.assigned)
                2 -> tab.text = getString(R.string.mentioned)
                3 -> tab.text = getString(R.string.requested)
            }
        }.attach()
    }

    override fun onPause() {
        super.onPause()
        binding.run {
            prPager.adapter = null
        }
    }
}