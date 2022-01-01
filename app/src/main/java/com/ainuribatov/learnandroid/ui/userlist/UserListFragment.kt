package com.ainuribatov.learnandroid.ui.userlist

import android.os.Bundle
import android.view.View
import com.ainuribatov.learnandroid.ui.userlist.UserListViewModel.ViewState
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentUserListBinding
import com.google.android.material.internal.TextWatcherAdapter
import dagger.hilt.android.AndroidEntryPoint
import dev.chrisbanes.insetter.applyInsetter
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import android.text.Editable
import com.ainuribatov.learnandroid.entity.Item
import com.ainuribatov.learnandroid.entity.SeparatorData
import com.ainuribatov.learnandroid.entity.UserData
import timber.log.Timber


@AndroidEntryPoint
class UserListFragment : BaseFragment(R.layout.fragment_user_list) {
    private val viewBinding by viewBinding(FragmentUserListBinding::bind)
    private val viewModel: UserListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.searchPeopleTextInputLayout.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.userListRecyclerView.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.searchPeopleTextInputLayout.isVisible = false
        viewBinding.searchPersonFloatingActionButton.setOnClickListener {
            viewBinding.searchPeopleTextInputLayout.isVisible =
                viewBinding.searchPeopleTextInputLayout.isVisible xor true
        }
        setupRecyclerView()
        subscribeToViewState()
        subscribeToSearchChanges()
    }

    private fun subscribeToSearchChanges() {
        viewBinding.searchPersonEditText.addTextChangedListener(object : TextWatcherAdapter() {
            override fun afterTextChanged(editable: Editable) {
                subscribeToViewState(editable.toString())
            }
        })
    }

    private fun setupRecyclerView(): ListAdapter =
        ListAdapter()
            .also {
                viewBinding.userListRecyclerView.adapter = it
            }


    private fun subscribeToViewState(filter: String? = null) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                Timber.d("started")
                viewModel.viewState.collect {
                    renderViewState(it, filter)
                }
            }
        }
    }

    private fun renderViewState(viewState: ViewState, filter: String?) {
        when (viewState) {
            is ViewState.Loading -> {
                viewBinding.userListRecyclerView.isVisible = false
                viewBinding.progressBar.isVisible = true
            }
            is ViewState.Data -> {
                viewBinding.userListRecyclerView.isVisible = true
                val adapter = viewBinding.userListRecyclerView.adapter as ListAdapter
                adapter.userList = decorateUsers(filterList(viewState.userList, filter))
                adapter.notifyDataSetChanged()
                viewBinding.progressBar.isVisible = false
            }
            is ViewState.Error -> {
                viewBinding.userListRecyclerView.isVisible = false
                viewBinding.progressBar.isVisible = false
            }
            is ViewState.Empty -> {
                viewBinding.progressBar.isVisible = false
                viewBinding.errorTextView.text = getString(R.string.empty_list_response)
            }
        }

    }


    private fun decorateUsers(users: List<UserData>): List<Item> {
        val decorated: MutableList<Item> = mutableListOf()
        for (i in users) {
            decorated.add(i)
            decorated.add(SeparatorData())
        }
        return decorated
    }

    private fun filterList(userList: List<UserData>, filter: String?): List<UserData> {
        val filtered: MutableList<UserData> = mutableListOf()
        val _filter = (filter ?: "").lowercase()
        for (user in userList) {
            if (listOf(user.firstName, user.lastName, user.userName, user.groupName).map { it ->
                    (it ?: "").lowercase().contains(_filter)
                }.any { it }) {
                filtered.add(user)
            }
        }
        return filtered
    }
}