package divyansh.tech.androgit.features.home.pull_requests

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import divyansh.tech.androgit.R

class PrAdapter(
    private val fragmentActivity: FragmentActivity
): FragmentStateAdapter(fragmentActivity) {
    
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> setupFragment(fragmentActivity.getString(R.string.created))
            1 -> setupFragment(fragmentActivity.getString(R.string.assigned))
            2 -> setupFragment(fragmentActivity.getString(R.string.mentioned))
            3 -> setupFragment(fragmentActivity.getString(R.string.requested))
            else -> setupFragment("")
        }
    }
    
    private fun setupFragment(itemString: String): PullRequestItemFragment =
        PullRequestItemFragment.newInstance(itemString)
}