package com.ainuribatov.learnandroid.ui.news

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentNewsBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    private val viewBinding by viewBinding(FragmentNewsBinding::bind)
    private val viewModel: NewsFragmentViewModel by viewModels()
}