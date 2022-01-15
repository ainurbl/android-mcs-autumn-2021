package com.ainuribatov.learnandroid.ui.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.R
import com.ainuribatov.learnandroid.databinding.FragmentOnboadringBinding
import com.ainuribatov.learnandroid.onboardingTextAdapterDelegate
import com.ainuribatov.learnandroid.ui.base.BaseFragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dev.chrisbanes.insetter.applyInsetter
import timber.log.Timber

class OnboardingFragment : BaseFragment(R.layout.fragment_onboadring) {

    private val viewBinding by viewBinding(FragmentOnboadringBinding::bind)

    private val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null

    private var player: ExoPlayer? = null

    private fun ViewPager2.setTextPages() {
        adapter =
            ListDelegationAdapter(onboardingTextAdapterDelegate()).apply {
                items =
                    listOf(
                        getString(R.string.onboarding_view_pager_text_1),
                        getString(R.string.onboarding_view_pager_text_2),
                        getString(R.string.onboarding_view_pager_text_3)
                    )
            }
    }

    private fun ViewPager2.attachDots(tabLayout: TabLayout) {
        TabLayoutMediator(tabLayout, this) { _, _ -> }.attach()
    }

    private fun setupView() {
        val soundButton = viewBinding.volumeControlButton
        val currentVol = player?.volume
        if (currentVol == 0f) {
            soundButton.setImageResource(R.drawable.ic_volume_off_white_24dp)
        } else {
            soundButton.setImageResource(R.drawable.ic_volume_up_white_24dp)
        }
        soundButton.setOnClickListener {
            val currentVol = player?.volume
            if (currentVol == 0f) {
                player?.volume = 1f
                soundButton.setImageResource(R.drawable.ic_volume_up_white_24dp)
            } else {
                player?.volume = 0f
                soundButton.setImageResource(R.drawable.ic_volume_off_white_24dp)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
        viewBinding.volumeControlButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.signUpButton.applyInsetter {
            type(navigationBars = true) { margin() }
        }
        viewBinding.playerView.player = player
        viewBinding.viewPager.setTextPages()
        viewBinding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                Timber.d("Current position: $position")
                super.onPageSelected(position)
                runnable = Runnable {
                    viewBinding.viewPager.currentItem = (position + 1) % 3
                }
                handler.postDelayed(
                    runnable!!,
                    2_000
                )
            }
        })
        viewBinding.viewPager.attachDots(viewBinding.onboardingTextTabLayout)

        viewBinding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signInFragment)
        }
        viewBinding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signUpFragment)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = SimpleExoPlayer.Builder(requireContext()).build().apply {
            addMediaItem(MediaItem.fromUri("asset:///onboarding.mp4"))
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
            volume = 0f
        }
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
        if (runnable != null) {
            handler.removeCallbacks(runnable!!)
            runnable = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}

