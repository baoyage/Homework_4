package syr.project.homework_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_recycler_view.*
import syr.project.homewo.MyMovieListAdapter

class RecyclerViewActivity : AppCompatActivity()/*,MyMovieListAdapter.MyItemClickListener*/ {
    var movieList: List<MovieData> = Gson().fromJson(movies, Array<MovieData>::class.java).asList()

    var posterTable:MutableMap<String, Int> = mutableMapOf()
    init{
        posterTable[movieList[0].title]=R.drawable.pci1aryw7oj2eyto2nmyekhhicp
        posterTable[movieList[1].title]=R.drawable.oyg9tl7fcrp4ez9vid6ukzwdndz
        posterTable[movieList[2].title]=R.drawable.riaoojrfvvhotyaogoi0wr7okse
        posterTable[movieList[3].title]=R.drawable.zgvbrulkupqpbwginedkjpyqum4
        posterTable[movieList[4].title]=R.drawable.t7xhp8sqtvanzecvn1oqrvwcxti
        posterTable[movieList[5].title]=R.drawable.q719jxxezooyaps6babgknononx
        posterTable[movieList[6].title]=R.drawable.hek3koduyrqk7fihpxsa6mt2zc3
        posterTable[movieList[7].title]=R.drawable.h1b7tw0t399vdjacwjh8m87469b
        posterTable[movieList[8].title]=R.drawable.velwphvmqeqkcxggneu8ymio52r
        posterTable[movieList[9].title]=R.drawable.plnlrtbuult0rh3xsjmpubiso3l
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        recyclerView.layoutManager= GridLayoutManager(this,1)
        val myAdapter= MyMovieListAdapter(movieList,posterTable,this)
//        myAdapter.setMyItemClickListener(this)
        recyclerView.adapter=myAdapter

    }

//    override fun onItemClick(movieList: List<MovieData>) {
//        TODO("Not yet implemented")
//    }
}