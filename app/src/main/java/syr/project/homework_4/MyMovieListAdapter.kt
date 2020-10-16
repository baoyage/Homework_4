package syr.project.homework_4


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MyMovieListAdapter(val movieList: List<MovieData>, val posterTable: MutableMap<String, Int>
) : RecyclerView.Adapter<MyMovieListAdapter.MovieViewHolder>() {
    var myListener:MyItemClickListener? = null
    lateinit var movie:MovieData
    var posterid: Int? = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val rVMovieTitle= view?.rVTitle
        val rVOverview= view?.rVOverview
        val rVposterid= view?.rVPosterid
        val rVRating= view?.rVRating
        init{
            view?.setOnClickListener {
                if(myListener!=null){
                    if(adapterPosition!=NO_POSITION){

                        myListener!!.onItemClickedFromAdapter(movieList[adapterPosition],posterTable[movieList[adapterPosition].title])
                    }
                }
            }
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.rVMovieTitle!!.text =movieList[position].title
        holder.rVOverview!!.text=movieList[position].overview
        holder.rVposterid!!.setImageResource(posterTable[movieList[position].title]!!)
        holder.rVRating!!.text= movieList[position].vote_average.toString()

    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    fun setMyItemClickListener(listener: MyItemClickListener) {
        this.myListener=listener
    }

    interface MyItemClickListener {
        fun onItemClickedFromAdapter(movie:MovieData, posterid: Int?)

    }

}


