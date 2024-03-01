package com.example.test_10.presentation.screen.home.to

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_10.R
import com.example.test_10.databinding.FragmentFromAccountBottomBinding
import com.example.test_10.databinding.FragmentToAccountBottomBinding
import com.example.test_10.presentation.adapter.from.FromAccountRecyclerAdapter
import com.example.test_10.presentation.event.from.FromAccountEvent
import com.example.test_10.presentation.event.to.ToAccountEvent
import com.example.test_10.presentation.screen.home.from.FromAccountViewModel
import com.example.test_10.presentation.state.from.FromAccountState
import com.example.test_10.presentation.state.to.ToAccountState
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ToAccountBottomFragment : BottomSheetDialogFragment(), AdapterView.OnItemSelectedListener {
    private var _binding: FragmentToAccountBottomBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ToAccountViewModel by viewModels()
    private lateinit var inputType: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToAccountBottomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setUp()
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUp() {
        setSpinner()
    }

    private fun setObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.toAccountState.collect {
                    handleState(it)
                }
            }
        }
    }

    private fun setSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.transfer_by,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
        }
        binding.spinner.onItemSelectedListener = this
    }

    private fun handleState(state: ToAccountState) {
        state.toAccount?.let {
            dismiss()
        }

        state.errorMessage?.let {
            toastMessage(it)
            viewModel.onEvent(ToAccountEvent.ResetErrorMessage)
        }

        binding.progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
    }

    private fun toastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    private fun setListener() {
        binding.btnSelect.setOnClickListener {
            val userInput = binding.etToAccountInput.text.toString()
            viewModel.onEvent(ToAccountEvent.FetchToAccount(userInput, inputType))
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        inputType = parent?.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}