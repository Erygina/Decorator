package com.example.decorator.ui.behavior

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.decorator.databinding.FragmentBehaviorBinding
import com.example.decorator.ui.behavior.decoratorBehavior.CodeImpl
import com.example.decorator.ui.behavior.decoratorBehavior.PushNotificationDecorator
import com.example.decorator.ui.behavior.decoratorBehavior.QRDecorator

class BehaviorFragment : Fragment() {

    private var _binding: FragmentBehaviorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(BehaviorViewModel::class.java)

        _binding = FragmentBehaviorBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val code = CodeImpl(activity)
        binding.codeButton.setOnClickListener {
            code.GetCode()
        }

        binding.pushButton.setOnClickListener {
            val pushNotification = PushNotificationDecorator(code, this)
            pushNotification.GetCode()
        }

        binding.qrButton.setOnClickListener(View.OnClickListener {
            val qrCode = QRDecorator(code, binding, activity)
            qrCode.GetCode()
        })
        return root
    }
}


