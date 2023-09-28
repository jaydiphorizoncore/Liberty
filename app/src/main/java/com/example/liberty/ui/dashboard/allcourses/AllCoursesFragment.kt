package com.example.liberty.ui.dashboard.allcourses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.FragmentAllCoursesFragmentBinding


class AllCoursesFragment : Fragment() {
    private lateinit var binding: FragmentAllCoursesFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_all_courses_fragment,
            container,
            false
        )
        return binding.root
    }

}