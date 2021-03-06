package divyansh.tech.androgit.features.home.issues

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.databinding.FragmentIssuesItemsBinding
import divyansh.tech.androgit.features.home.issues.epoxy.EpoxyIssueController
import divyansh.tech.utility.ResultWrapper

@AndroidEntryPoint
class IssuesItemFragment: Fragment() {

    private val TAG = this.javaClass.simpleName
    private lateinit var binding: FragmentIssuesItemsBinding
    private val viewModel: IssueItemViewModel by viewModels()
    private lateinit var filterString: String

    private val issueController by lazy {
        EpoxyIssueController()
    }

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesItemsBinding.inflate(
            inflater,
            container,
            false
        )
        filterString = arguments?.getString(FILTER_STRING).toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("FILTER_STRING", filterString.toLowerCase())
        viewModel.fetchIssues(queryString = filterString.toLowerCase())
        setupObservers()
        setupRecyclerView()
    }

    private fun setupObservers() {
        viewModel.issues.observe(viewLifecycleOwner, {
            when (it) {
                is ResultWrapper.Success -> issueController.setData(it.data)
                is ResultWrapper.Error -> {}
                is ResultWrapper.Loading -> {}
            }
        })
    }

    private fun setupRecyclerView() {
        binding.issuesRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = issueController.adapter
        }
    }
}