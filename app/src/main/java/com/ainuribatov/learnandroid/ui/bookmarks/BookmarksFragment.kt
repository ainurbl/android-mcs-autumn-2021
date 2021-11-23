package com.ainuribatov.learnandroid.ui.bookmarks

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentBookmarksBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment

class BookmarksFragment : BaseFragment(R.layout.fragment_bookmarks) {

    private val viewBinding by viewBinding(FragmentBookmarksBinding::bind)
    private val viewModel: BookmarksFragmentViewModel by viewModels()
}