package com.example.spinners2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners2.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnListview.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_ej01ListViewFragment)
        }

        binding.btnSpinners.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SpinnersFragment)
        }

        binding.btnAutocompletar.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_autocompletarFragment)
        }
    }

}