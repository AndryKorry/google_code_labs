package com.vynokurov.wordsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vynokurov.wordsapp.ui.adapter.LetterAdapter
import com.vynokurov.wordsapp.R
import com.vynokurov.wordsapp.data.SettingsDataStore
import com.vynokurov.wordsapp.databinding.FragmentLetterListBinding
import kotlinx.coroutines.launch

class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    private lateinit var SettingsDataStore: SettingsDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
        SettingsDataStore = SettingsDataStore(requireContext())
        SettingsDataStore.preferencesFlow.asLiveData().observe(viewLifecycleOwner) { value ->
            isLinearLayoutManager = value
            chooseLayout()
            activity?.invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun chooseLayout() {
        when(isLinearLayoutManager) {
            true -> {
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = LetterAdapter()
            }
            false -> {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
            recyclerView.adapter = LetterAdapter()
            }
        }
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                lifecycleScope.launch{
                    SettingsDataStore.saveLayoutToPreferencesStore(isLinearLayoutManager,requireContext())
                }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}