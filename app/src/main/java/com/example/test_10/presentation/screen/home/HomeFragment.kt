package com.example.test_10.presentation.screen.home

import com.example.test_10.databinding.FragmentHomeBinding
import com.example.test_10.presentation.base.BaseFragment
import com.example.test_10.presentation.screen.home.from.FromAccountBottomFragment
import com.example.test_10.presentation.screen.home.to.ToAccountBottomFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun bind() {
    }

    override fun bindListeners() {
        binding.layoutFrom.setOnClickListener {
            val bottomFromAccountFragment = FromAccountBottomFragment()
            bottomFromAccountFragment.show(parentFragmentManager, "bottom_fragment_fromAccount")
        }

        binding.layoutTo.setOnClickListener{
            val bottomToAccountFragment = ToAccountBottomFragment()
            bottomToAccountFragment.show(parentFragmentManager, "bottom_fragment_toAccount")
        }
    }

    override fun bindObserves() {
    }

}