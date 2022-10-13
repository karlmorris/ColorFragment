package edu.temple.colorfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), SelectionFragment.ColorSelectedInterface {

    lateinit var displayFragment: DisplayFragment

    private lateinit var colorViewModel: ColorViewModel

    private var landscape = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        landscape = findViewById<View>(R.id.displayContainer) != null

        displayFragment = DisplayFragment()


        colorViewModel = ViewModelProvider(this)[ColorViewModel::class.java]


        supportFragmentManager
            .beginTransaction()
            .add(R.id.selectionContainer, SelectionFragment.newInstance(getColors()))
            .commit()

        if (landscape)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.displayContainer, DisplayFragment())
                .commit()


    }


    private fun getColors() : Array<String> {
        return arrayOf(
            "Red",
            "White",
            "Green",
            "Blue",
            "Cyan",
            "Grey",
            "Teal",
            "Magenta",
            "Silver",
            "Maroon",
            "Yellow",
        )
    }

    override fun colorSelected() {
        if (!landscape)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.selectionContainer, DisplayFragment())
                .addToBackStack(null)
                .commit()
    }
}