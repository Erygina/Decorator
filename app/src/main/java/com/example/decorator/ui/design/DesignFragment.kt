package com.example.decorator.ui.design

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.decorator.R
import com.example.decorator.databinding.FragmentDesignBinding
import com.example.decorator.ui.design.decoratorDesign.BorderDecorator
import com.example.decorator.ui.design.decoratorDesign.PinkCat
import com.example.decorator.ui.design.decoratorDesign.RotateDecorator
import com.example.decorator.ui.design.decoratorDesign.TransparentDecorator

class DesignFragment : Fragment() {

    private var _binding: FragmentDesignBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DesignViewModel::class.java)

        _binding = FragmentDesignBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val cat = PinkCat(binding)

        binding.drawButton.setOnClickListener{
            cat.Draw()
        }

        binding.rotateButton.setOnClickListener {
            val rotateCat = RotateDecorator(binding, cat)
            rotateCat.Draw()
        }

        binding.transparentButton.setOnClickListener {
            val transparentCat = TransparentDecorator(binding, cat)
            transparentCat.Draw()
        }

        binding.borderButton.setOnClickListener {
            val borderedCat = BorderDecorator(binding, cat)
            borderedCat.Draw()
        }

//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}