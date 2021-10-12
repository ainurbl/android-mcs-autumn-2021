package com.ainuribatov.learnandroid

import android.os.Bundle
import android.view.View
import com.ainuribatov.learnandroid.UserListViewModel.ViewState
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.databinding.FragmentUserListBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class UserListFragment : BaseFragment(R.layout.fragment_user_list) {
    private val viewBinding by viewBinding(FragmentUserListBinding::bind)
    private val viewModel: UserListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        subscribeToViewState()
    }

    private fun setupRecyclerView(): ListAdapter =
        ListAdapter()
            .also {
                viewBinding.userListRecyclerView.adapter = it
            }


    private fun subscribeToViewState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect(::renderViewState)
            }
        }
    }

    private fun renderViewState(viewState: ViewState) {
        when (viewState) {
            is ViewState.Loading -> {
                viewBinding.userListRecyclerView.isVisible = false
                viewBinding.progressBar.isVisible = true
            }
            is ViewState.Data -> {
                viewBinding.userListRecyclerView.isVisible = true
                val adapter = viewBinding.userListRecyclerView.adapter as ListAdapter
                adapter.userList = viewState.userList
                adapter.notifyDataSetChanged()
                viewBinding.progressBar.isVisible = false
            }
        }

    }
}