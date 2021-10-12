package com.ainuribatov.learnandroid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ainuribatov.learnandroid.databinding.FragmentOnboadringBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import by.kirich1409.viewbindingdelegate.viewBinding

class OnboardingFragment : Fragment(R.layout.fragment_onboadring) {

    private val viewBinding by viewBinding(FragmentOnboadringBinding::bind)

    private var player: ExoPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        player = SimpleExoPlayer.Builder(requireContext()).build().apply {
            addMediaItem(MediaItem.fromUri("assets:///onboarding.mp4"))
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
        }
        viewBinding.playerView.player = player
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }
}