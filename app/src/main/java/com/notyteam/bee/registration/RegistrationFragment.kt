package com.notyteam.bee.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.notyteam.bee.R
import com.notyteam.bee.registration.login.fragment.LoginFragment
import com.notyteam.bee.registration.newaccount.fragment.NewAccountFragment
import com.notyteam.bee.utils.OnBackPressed

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val btn_enter = view.findViewById<Button>(R.id.btn_enter)
        val btn_registration = view.findViewById<Button>(R.id.btn_registration)
        val tv_enter_without_registration =
            view.findViewById<TextView>(R.id.tv_enter_without_registration)

        // Set a click listener for text view object
        btn_enter.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_registration,
                LoginFragment()
            )?.commit()
        }

        btn_registration.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(
                R.id.fragment_container_registration,
                NewAccountFragment()
            )?.commit()
        }

        return view
    }


}