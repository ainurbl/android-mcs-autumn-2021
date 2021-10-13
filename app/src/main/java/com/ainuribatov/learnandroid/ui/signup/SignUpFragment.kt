package com.ainuribatov.learnandroid.ui.signup

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.ui.base.BaseFragment
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment(R.layout.fragment_sign_up) {

    private val viewBinding by viewBinding(FragmentSignUpBinding::bind)
    private val viewModel: SignUpViewModel by viewModels()
}