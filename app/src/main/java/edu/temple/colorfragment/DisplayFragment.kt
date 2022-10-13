package edu.temple.colorfragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {

    private lateinit var canvas: View

    private lateinit var colorViewModel: ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorViewModel = ViewModelProvider(requireActivity())[ColorViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false).also {
            canvas = it.findViewById(R.id.canvas)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        colorViewModel.getColor().observe(requireActivity()) {
            changeColor(it)
        }
    }

    fun changeColor (color: String) {
        canvas.setBackgroundColor(Color.parseColor(color))
    }

}