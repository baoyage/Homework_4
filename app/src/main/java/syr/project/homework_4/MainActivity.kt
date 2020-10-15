package syr.project.homework_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val appBar = supportActionBar

        appBar!!.setDisplayShowHomeEnabled(true)
//        appBar?.setDisplayHomeAsUpEnabled(true)

        aboutMe.setOnClickListener{
            var fragment=supportFragmentManager.findFragmentById(R.id.container1)
            if( fragment == null ){ // add about me fragment
                aboutMe.text = "Remove Fragment"
                fragment=FrontPageFragment()
                supportFragmentManager.beginTransaction().add(R.id.container1,fragment).commit()
            } else { // remove  the fragment
                supportFragmentManager.beginTransaction().remove(fragment).commit()
                aboutMe.text = "About Me"
            }

        }

        movieList.setOnClickListener{
            val intent = Intent(this, RecyclerViewActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}