package com.example.test_10.presentation.screen.home.from

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_10.R
import com.example.test_10.databinding.FragmentFromAccountBottomBinding
import com.example.test_10.presentation.adapter.from.FromAccountRecyclerAdapter
import com.example.test_10.presentation.event.from.FromAccountEvent
import com.example.test_10.presentation.model.from.FromAccount
import com.example.test_10.presentation.state.from.FromAccountState
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FromAccountBottomFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentFromAccountBottomBinding? = null
    private val binding get() = _binding!!

    private var fromAccountRecyclerAdapter: FromAccountRecyclerAdapter? = null
    private val viewModel: FromAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFromAccountBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fromAccountState.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun setUp() {
        setAdapter()
    }

    private fun setAdapter() {
        // არვიცი რატო არ მუშაობს

//        fromAccountRecyclerAdapter = FromAccountRecyclerAdapter()
//        binding.apply {
//            rvFromAccount.layoutManager = LinearLayoutManager(requireContext())
//            rvFromAccount.setHasFixedSize(true)
//            rvFromAccount.adapter = fromAccountRecyclerAdapter
//        }
        viewModel.onEvent(FromAccountEvent.FetchFromAccount)
    }

    private fun handleState(state: FromAccountState) {
        state.fromAccountList?.let {
            fromAccountRecyclerAdapter = FromAccountRecyclerAdapter()
            binding.apply {
                rvFromAccount.layoutManager = LinearLayoutManager(requireContext())
                rvFromAccount.setHasFixedSize(true)
                rvFromAccount.adapter = fromAccountRecyclerAdapter
            }
            fromAccountRecyclerAdapter?.submitList(it)
        }

        state.errorMessage?.let {
            toastMessage(it)
            viewModel.onEvent(FromAccountEvent.ResetErrorMessage)
        }

        binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
    }


    private fun toastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}
