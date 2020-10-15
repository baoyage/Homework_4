package syr.project.homewo

import syr.project.homework_4.MovieData
import syr.project.homework_4.R



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MyMovieListAdapter(val movieList: List<MovieData>, val posterTable: MutableMap<String, Int>, val context:
Context
) : RecyclerView.Adapter<MyMovieListAdapter.MovieViewHolder>() {
//    var myListener:MyItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val movieTitle= view?.title

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle!!.text =movieList[position].title

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

//    fun setMyItemClickListener(listener: MyItemClickListener) {
//        this.myListener=listener
//    }
//
//    interface MyItemClickListener {
//        fun onItemClick(movieList: List<MovieData>)
//
//    }

}


