package syr.project.homework_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class RecyclerViewActivity : AppCompatActivity(),RecyclerViewFragment.OnRecyclerInteractionListener {


    var movie: MovieData? =null
    var posterid: Int? =null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment,RecyclerViewFragment()).commit()
        }
//        recyclerView.layoutManager= GridLayoutManager(this,1)
//        val myAdapter= MyMovieListAdapter(movieList,posterTable,this)
//        myAdapter.setMyItemClickListener(this)
//        recyclerView.adapter=myAdapter

    }

    override fun onItemClicked(movie:MovieData, posterid: Int?) {
        Toast.makeText(this,movie.title,Toast.LENGTH_LONG).show()
        this.movie=movie
        this.posterid=posterid


        supportFragmentManager.beginTransaction().replace(R.id.fragment,DetailFragment.newInstance(movie,
            posterid!!
        )).addToBackStack(null).commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable("movie",movie)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState!=null){
            movie=savedInstanceState.getSerializable("movie")as MovieData
        }
    }


}