package com.example.btvn_buoi6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.btvn_buoi6.databinding.FragmentLoginBinding

class Login : Fragment() {
    private var _binding: FragmentLoginBinding? = null;
    private val binding get() = _binding!!;



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtSignup.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, SignUp())
                .addToBackStack(null)
                .commit()
        }

        binding.forgot.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.openning, ForgotPassword())
                .addToBackStack(null)
                .commit()
        }


    }
}