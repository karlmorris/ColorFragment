package edu.temple.colorfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), SelectionFragment.ColorSelectedInterface {

    lateinit var displayFragment: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment = DisplayFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.selectionContainer, SelectionFragment.newInstance(getColors()))
            .add(R.id.displayContainer, displayFragment)
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

    override fun colorSelected(color: String) {
        displayFragment.changeColor(color)
    }
}