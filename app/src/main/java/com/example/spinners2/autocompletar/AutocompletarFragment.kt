package com.example.spinners2.autocompletar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners2.databinding.FragmentAutocompletarBinding
import com.example.spinners2.spinners.SpinnersFragmentDirections


class AutocompletarFragment : Fragment() {
    private var _binding: FragmentAutocompletarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutocompletarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEj01.setOnClickListener {
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj01AutocompFragment())
        }
        binding.btnEj02.setOnClickListener {
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj02AutocompFragment())
        }
        binding.btnEj022.setOnClickListener {
            findNavController().navigate(AutocompletarFragmentDirections.actionAutocompletarFragmentToEj03AutocompFragment())
        }

    }


}