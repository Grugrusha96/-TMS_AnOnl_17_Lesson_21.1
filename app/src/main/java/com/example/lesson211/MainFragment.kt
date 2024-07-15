package com.example.lesson211

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson211.adapter.UserAdapter
import com.example.lesson211.databinding.FragmentMainBinding
import kotlin.math.log


class MainFragment : Fragment(), Subscriber {

    private var binding: FragmentMainBinding? = null

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
        NotesDB.subscribe(this)
        setList()
        binding?.openFragmentBatton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.conteiner, AddNotesFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        NotesDB.unsubscribe(this)
    }

    override fun update() {
        setList()
    }

    private fun setList() {
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
            (adapter as? UserAdapter)?.submitList(NotesDB.getListNotes())
        }
    }
}