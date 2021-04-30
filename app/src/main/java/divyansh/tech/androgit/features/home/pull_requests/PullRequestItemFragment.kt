package divyansh.tech.androgit.features.home.pull_requests

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.databinding.FragmentPrItemsBinding
import divyansh.tech.utility.C
import divyansh.tech.utility.ResultWrapper

@AndroidEntryPoint
class PullRequestItemFragment: Fragment() {

    private lateinit var binding: FragmentPrItemsBinding
    private lateinit var itemType: C.TYPE
    private val viewModel: PRViewModel by viewModels()

    companion object {
        private const val ITEM_STRING = "item_string"

        fun newInstance(itemType: C.TYPE): PullRequestItemFragment {
            val frag = PullRequestItemFragment()
            frag.arguments = Bundle().apply {
                putSerializable(ITEM_STRING, itemType)
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
        itemType = arguments?.getSerializable(ITEM_STRING) as C.TYPE
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllPRs(itemType)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.pullRequests.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultWrapper.Success -> Log.i("PULLS", it.data.toString())
                is ResultWrapper.Error -> {}
                is ResultWrapper.Loading -> {}
            }
        })
    }
}