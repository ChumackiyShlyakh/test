package com.notyteam.bee.topics.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.core.ui.MainActivity
import com.notyteam.bee.profile_fragments.ProfileAccountDetailFragment
import com.notyteam.bee.profile_fragments.ProfileRefillFragment
import com.notyteam.bee.topics.profile.fragment.ProfileFragment
import kotlinx.android.synthetic.main.fragment_feedback.*
import kotlinx.android.synthetic.main.fragment_profile_payments.*

class FeedbackFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feedback, container, false)

//        val viewModel = ViewModelProviders.of(this)[ProfileViewModel::class.java]
//        val binding: FragmentProfileBinding = FragmentProfileBinding().inflate(inflater, container, false)
//        binding.model

//        val imgbtn_fragment_feedback_back = imgbtn_fragment_feedback_back
        val btn_fragment_feedback_send = btn_fragment_feedback_send

//        imgbtn_fragment_feedback_back?.setOnClickListener(View.OnClickListener {
////            MainActivity.drawer.closeDrawer(GravityCompat.START)
//        })

        btn_fragment_feedback_send?.setOnClickListener(View.OnClickListener {
//            fragmentManager?.beginTransaction()?.replace(
//                R.id.fragment_container_main_activity,
//                ProfileAccountDetailFragment()
//            )?.commit()
        })

        return view
//        return binding.root
    }
}
