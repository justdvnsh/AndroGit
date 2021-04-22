package divyansh.tech.androgit.features.home.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.androgit.R
import divyansh.tech.androgit.databinding.FragmentFeedBinding
import divyansh.tech.utility.ResultWrapper

@AndroidEntryPoint
class FeedFragment: Fragment() {

    private lateinit var binding: FragmentFeedBinding
    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_feed,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewModel.getEvents()
    }

    private fun setupObservers() {
        viewModel.events.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultWrapper.Success -> binding.feed.text = it.data?.toString()
                is ResultWrapper.Error -> binding.feed.text = it.message?.toString()
                else -> {}
            }
        })
    }
}