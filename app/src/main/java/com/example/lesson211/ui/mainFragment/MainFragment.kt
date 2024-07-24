package com.example.lesson211.ui.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson211.R
import com.example.lesson211.data.Notes
import com.example.lesson211.ui.mainFragment.adapter.UserAdapter
import com.example.lesson211.databinding.FragmentMainBinding
import com.example.lesson211.ui.addNotes.AddNotesFragment
import com.example.lesson211.ui.notes.NotesFragment

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listNotes.observe(viewLifecycleOwner){
             setList(it)
        }
        viewModel.getListNotes()
        binding?.openFragmentBatton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.conteiner, AddNotesFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun setList(list: List<Notes>) {
            binding?.recyclerView?.run {
                if (adapter == null) {
                    Log.e("setList", "in")
                layoutManager = LinearLayoutManager(requireContext())
                adapter = UserAdapter { notes ->

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.conteiner, NotesFragment.getFragment(notes.id))
                        .addToBackStack(null)
                        .commit()

                }
            }
                Log.e("setList", "set")
            (adapter as? UserAdapter)?.submitList(list)
        }
    }
}