package com.tugbaozaydin.retrofitexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.tugbaozaydin.retrofitexample.databinding.FragmentUserDetailBinding


class UserDetailFragment : Fragment() {
    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<UserDetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.userCompany.text = args.userData.company
        binding.userJobDesc.text = args.userData.jobDesc
        binding.userJobTitle.text = args.userData.jobTitle

        return view
    }
}