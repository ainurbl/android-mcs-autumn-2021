package com.ainuribatov.learnandroid.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentNewsBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment
import dev.chrisbanes.insetter.applyInsetter

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val viewBinding by viewBinding(FragmentNewsBinding::bind)
    private val viewModel: NewsFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.newsRecyclerView.applyInsetter {
            type(statusBars = true) { margin() }
        }
    }
}