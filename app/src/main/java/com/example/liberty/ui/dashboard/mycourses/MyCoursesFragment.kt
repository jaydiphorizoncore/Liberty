package com.example.liberty.ui.dashboard.mycourses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.liberty.R
import com.example.liberty.databinding.FragmentMyCoursesBinding


class MyCoursesFragment : Fragment() {

    private lateinit var binding: FragmentMyCoursesBinding

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
            R.layout.fragment_my_courses,
            container,
            false
        )
        return binding.root
    }


}