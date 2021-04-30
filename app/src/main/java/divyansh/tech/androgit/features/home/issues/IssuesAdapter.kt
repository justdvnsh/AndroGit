package divyansh.tech.androgit.features.home.issues

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import divyansh.tech.androgit.R

/*
* View pager adapter for Issues
* */
class IssuesAdapter(
    private val fragmentActivity: FragmentActivity
): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        Toast.makeText(fragmentActivity.baseContext, "$position", Toast.LENGTH_SHORT).show()
        return when (position) {
            0 -> setupFragment(fragmentActivity.getString(R.string.all_issues))
            1 -> setupFragment(fragmentActivity.getString(R.string.assigned_issues))
            2 -> setupFragment(fragmentActivity.getString(R.string.created_issues))
            3 -> setupFragment(fragmentActivity.getString(R.string.mentioned_issues))
            4 -> setupFragment(fragmentActivity.getString(R.string.subscribed_issues))
            else -> setupFragment("")
        }
    }

    private fun setupFragment(filterString: String): IssuesItemFragment =
        IssuesItemFragment.newInstance(filterString)
}