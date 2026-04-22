package com.example.btvn_buoi6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.btvn_buoi6.databinding.FragmentForgotPasswordBinding


class ForgotPassword : Fragment() {
    private var _binding: FragmentForgotPasswordBinding? = null;

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.forgotBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning,Login())
                .commit()
        }

        binding.txtLogin.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, Login())
                .commit()
        }

        binding.forgotSendCode.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, ForgotPasswordCode())
                .commit()
        }


    }
}