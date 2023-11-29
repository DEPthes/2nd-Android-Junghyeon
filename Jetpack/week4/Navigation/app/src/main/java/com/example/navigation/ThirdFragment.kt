package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.navigation.databinding.FragmentFirstBinding
import com.example.navigation.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(layoutInflater,container,false)
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRed.setOnClickListener {
            viewModel.setColor(binding.btnRed.text.toString())
            Navigation.findNavController(it).navigate(R.id.action_thirdFragment_to_fourthFragment)

        }
        binding.btnBlue.setOnClickListener {
            viewModel.setColor(binding.btnBlue.text.toString())
            Navigation.findNavController(it).navigate(R.id.action_thirdFragment_to_fourthFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}