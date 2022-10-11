package edu.temple.colorfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.selectionContainer, SelectionFragment.newInstance(getColors()))
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
}