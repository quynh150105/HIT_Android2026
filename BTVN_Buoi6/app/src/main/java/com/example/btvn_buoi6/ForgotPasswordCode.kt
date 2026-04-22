package com.example.btvn_buoi6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.btvn_buoi6.databinding.FragmentFotgotPasswordCodeBinding

class ForgotPasswordCode : Fragment() {
   private var _binding: FragmentFotgotPasswordCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFotgotPasswordCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.forgotCodeVerify.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, ResetPassword())
                .commit()
        }

        binding.forgotCodeBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, ForgotPassword())
                .commit();
        }
    }
}