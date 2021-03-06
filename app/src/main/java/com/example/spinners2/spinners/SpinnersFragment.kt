package com.example.spinners2.spinners

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
            navToExample()
        }

    }


    private fun navToExample() {
        findNavController().navigate(
            when (binding.spinner.selectedItemPosition) {
                0 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj01EntriesFragment()
                1 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj02OnItemSelectedFragment()
                2 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj03FromArrayFragment()
                3 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj04FromResourceFragment()
                4 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj05FromArrayListFragment()
                5 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj06Fragment()
                else -> throw Exception("Ejemplo no existente")
            }
        )
    }
}