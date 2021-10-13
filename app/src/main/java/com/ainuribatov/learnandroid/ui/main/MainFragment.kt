package com.ainuribatov.learnandroid.ui.main

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentMainBinding

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val viewBinding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainFragmentViewModel by viewModels()
}