package com.vynokurov.app_bus_schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.app_bus_schedule.database.schedule.BusScheduleViewModelFactory
import com.vynokurov.app_bus_schedule.database.viewModels.BusScheduleViewModel
import com.vynokurov.app_bus_schedule.databinding.FullScheduleFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FullScheduleFragment : Fragment() {

    private var _binding: FullScheduleFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BusScheduleViewModel by activityViewModels {
        BusScheduleViewModelFactory((activity?.application as BusScheduleApplication).database.scheduleDao())
    }

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FullScheduleFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val busStopAdapter = BusStopAdapter {
            val action = FullScheduleFragmentDirections.actionFullScheduleFragmentToStopScheduleFragment(stopName = it.stopName)
            view.findNavController().navigate(action)
        }
        recyclerView.adapter = busStopAdapter
        lifecycle.coroutineScope.launch {
            viewModel.fullSchedule().collect {
                busStopAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
