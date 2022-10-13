package edu.temple.colorfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionFragment : Fragment() {

    private lateinit var colors: Array<String>

    private val COLOR_KEY = "colors"

    private lateinit var recyclerView: RecyclerView

    private lateinit var colorViewModel : ColorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        colorViewModel = ViewModelProvider(requireActivity())[(ColorViewModel::class.java)]

        arguments?.let {
            it.getStringArray(COLOR_KEY)?.let{
                colors = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false).also {
            recyclerView = it.findViewById(R.id.recyclerView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callback = {color: String -> colorViewModel.setColor(color)}//(requireActivity() as ColorSelectedInterface).colorSelected(color)}


        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = ColorAdapter(colors, callback)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(colors: Array<String>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(COLOR_KEY, colors)
                }
            }
    }

    interface ColorSelectedInterface {
        fun colorSelected(color: String)
    }
}