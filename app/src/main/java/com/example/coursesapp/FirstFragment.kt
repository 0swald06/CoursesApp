package com.example.coursesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coursesapp.Modelo.Local.Database.CoursesEntity
import com.example.coursesapp.ViewModel.CoursesViewModel
import com.example.coursesapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var mBinding: FragmentFirstBinding
private val mViewModel:CoursesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter=CoursesAdapter()
        mBinding.recyclerview.adapter=adapter
        mBinding.recyclerview.layoutManager=LinearLayoutManager(context)
        mViewModel.getCourseList().observe(viewLifecycleOwner,{

            it?.let {
                adapter.update(it)
            }


        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
       // mBinding = null
    }
}