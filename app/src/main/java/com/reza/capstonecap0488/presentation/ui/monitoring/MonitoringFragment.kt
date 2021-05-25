package com.reza.capstonecap0488.presentation.ui.monitoring

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.reza.capstonecap0488.R
import com.reza.capstonecap0488.databinding.FragmentMonitoringBinding

class MonitoringFragment : Fragment() {

    private lateinit var monitoringViewModel: MonitoringViewModel
    private lateinit var binding:FragmentMonitoringBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMonitoringBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)







    }
}