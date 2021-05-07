package divyansh.tech.androgit.features.home.pull_requests

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import divyansh.tech.androgit.R
import divyansh.tech.utility.C

class PrAdapter(
    private val fragment: Fragment
): FragmentStateAdapter(fragment) {
    
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> setupFragment(C.TYPE.CREATED)
            1 -> setupFragment(C.TYPE.ASSIGNED)
            2 -> setupFragment(C.TYPE.MENTIONED)
            3 -> setupFragment(C.TYPE.REQUESTED)
            else -> setupFragment(C.TYPE.ASSIGNED)
        }
    }
    
    private fun setupFragment(itemType: C.TYPE): PullRequestItemFragment =
        PullRequestItemFragment.newInstance(itemType)
}