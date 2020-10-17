package syr.project.homework_4


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MyMovieListAdapter(var movieList: ArrayList<MovieData>, var posterTable: MutableMap<String, Int>
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
        val rVCheckBox= view?.rVCheckBox
        init{
            rVCheckBox?.setOnCheckedChangeListener { rVCheckBox,isChecked->
                movieList[adapterPosition].checked=isChecked

            }
            view?.setOnClickListener {
                if(myListener!=null){
                    if(adapterPosition!=NO_POSITION){

                        myListener!!.onItemClickedFromAdapter(movieList[adapterPosition],posterTable[movieList[adapterPosition].title])
                    }
                }
            }
            view?.setOnLongClickListener {
                if(myListener!=null){
                    if(adapterPosition!=NO_POSITION){

                        myListener!!.onItemLongClickedFromAdapter(adapterPosition)
                    }
                }
                true
            }
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie=movieList[position]
        holder.rVMovieTitle!!.text =movie.title
        holder.rVOverview!!.text=movie.overview
        holder.rVposterid!!.setImageResource(posterTable[movie.title]!!)
        holder.rVRating!!.text= movie.vote_average.toString()
        holder.rVCheckBox!!.isChecked= movie.checked!!


    }

    override fun getItemCount(): Int {
        return movieList.size
    }


    fun setMyItemClickListener(listener: MyItemClickListener) {
        this.myListener=listener
    }

    interface MyItemClickListener {
        fun onItemClickedFromAdapter(movie:MovieData, posterid: Int?)
        fun onItemLongClickedFromAdapter(position : Int)

    }
    fun setSelectAll() {
        for( i in movieList.indices){
            movieList[i].checked = true
        }
        notifyDataSetChanged()
    }
    fun setClearAll() {
        for( i in movieList.indices){
            movieList[i].checked = false
        }
        notifyDataSetChanged()
    }
    fun deleteMovies() {
        var cnt = 0
        for(i in 0 until movieList.size)
            if(movieList[i].checked!!)
                cnt += 1
        for(i in 0 until cnt){
            for(j in movieList.indices){
                if(movieList[j].checked!!){
//                    posterTable.remove(movieList[j].title)
                    movieList.removeAt(j)


//                    movieList.removeAt(j)
                    notifyItemRemoved(j)
                    break
                }
            }
        }
        notifyDataSetChanged()

    }
    fun duplicateMovie(position: Int){

        var movie=movieList[position].copy()
        movieList.add(position+1,movie)
        notifyItemInserted(position+1)

    }


}




