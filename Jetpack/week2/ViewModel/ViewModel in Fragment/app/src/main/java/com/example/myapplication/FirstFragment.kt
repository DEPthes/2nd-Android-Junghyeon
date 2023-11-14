package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var activity: MainActivity
    private lateinit var sharedViewModel: SharedViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = requireActivity() as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_first,container,false)
        sharedViewModel = ViewModelProvider(activity).get(SharedViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            sharedViewModel.count = (binding.edit.text.toString().toInt())
            activity.replaceFragment(SecondFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}