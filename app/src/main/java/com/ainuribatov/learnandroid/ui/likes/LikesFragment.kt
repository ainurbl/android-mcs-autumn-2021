package com.ainuribatov.learnandroid.ui.likes

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentLikesBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment

class LikesFragment : BaseFragment(R.layout.fragment_likes) {

    private val viewBinding by viewBinding(FragmentLikesBinding::bind)
    private val viewModel: LikesFragmentViewModel by viewModels()
}