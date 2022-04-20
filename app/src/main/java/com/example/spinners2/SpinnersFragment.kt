package com.example.spinners2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners2.databinding.FragmentSpinnersBinding

class SpinnersFragment : Fragment() {
    private var _binding: FragmentSpinnersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpinnersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSeleccion.setOnClickListener {
            findNavController().navigate(
                when (binding.spinner.selectedItemPosition) {
                    0 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj01EntriesFragment()
                    1 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj02OnItemSelectedFragment()
                    else -> throw Exception("Opción no existente")
                }


            )
        }

    }
}