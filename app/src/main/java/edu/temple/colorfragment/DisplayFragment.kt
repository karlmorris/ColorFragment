package edu.temple.colorfragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DisplayFragment : Fragment() {

    private lateinit var canvas: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false).also {
            canvas = it.findViewById(R.id.canvas)
        }
    }

    fun changeColor (color: String) {
        canvas.setBackgroundColor(Color.parseColor(color))
    }

}