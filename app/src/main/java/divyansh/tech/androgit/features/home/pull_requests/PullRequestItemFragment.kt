package divyansh.tech.androgit.features.home.pull_requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.databinding.FragmentPrItemsBinding

@AndroidEntryPoint
class PullRequestItemFragment: Fragment() {

    private lateinit var binding: FragmentPrItemsBinding
    private lateinit var itemString: String

    companion object {
        private const val ITEM_STRING = "item_string"

        fun newInstance(itemString: String): PullRequestItemFragment {
            val frag = PullRequestItemFragment()
            frag.arguments = Bundle().apply {
                putString(ITEM_STRING, itemString)
            }
            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPrItemsBinding.inflate(
            inflater,
            container,
            false
        )
        itemString = arguments?.getString(ITEM_STRING).toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}