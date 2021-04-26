package divyansh.tech.androgit.features.home.issues

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssuesItemFragment: Fragment() {

    private val TAG = this.javaClass.simpleName

    companion object {
        const val FILTER_STRING: String = "filter_string"

        fun newInstance(filterString: String): IssuesItemFragment {
            val frag = IssuesItemFragment()
            frag.arguments = Bundle().apply {
                putString(FILTER_STRING, filterString)
            }
            return frag
        }
    }
}