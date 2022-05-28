package com.nebvuu.tothetop.ui.home

import android.graphics.Outline
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.CircleCropTransformation
import com.nebvuu.tothetop.R
import com.nebvuu.tothetop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textHome
        //val textTest: TextView = binding.test
        val ivProfileImage: ImageView = binding.ivProfileImage

        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        homeViewModel.textTest.observe(viewLifecycleOwner) {
            //textTest.text = it
        }

        homeViewModel.image.observe(viewLifecycleOwner){
            ivProfileImage.load(R.drawable.profile_user){
                crossfade(true)
                transformations(CircleCropTransformation())
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}