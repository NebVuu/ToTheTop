package com.nebvuu.tothetop.ui.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nebvuu.tothetop.R
import com.nebvuu.tothetop.databinding.FragmentHomeBinding
import com.nebvuu.tothetop.ui.AddPeakActivity

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
        val floatingActionButton: FloatingActionButton = binding.fabAdd
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

        floatingActionButton.setOnClickListener {
            //Toast.makeText(context, "FAB ADD", Toast.LENGTH_SHORT).show();
            activity?.let {
                val intent = Intent(it, AddPeakActivity::class.java)
                it.startActivity(intent)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}