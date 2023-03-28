package com.example.gonggu.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gonggu.MainActivity
import com.example.gonggu.databinding.FragmentProfileBinding
import com.example.gonggu.ui.location.LocationFragment
import com.example.gonggu.ui.post.PostFragment

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        val activity = activity as MainActivity
        val myPost = binding!!.myPost
        val myLocation = binding!!.myLocation

        // 내가 쓴 글
        myPost.setOnClickListener {
            activity.replaceFragment(PostFragment())
        }
        // 내 위치 설정
        myLocation.setOnClickListener {
            activity.replaceFragment(LocationFragment())
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}