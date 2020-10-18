package syr.project.homework_4


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.NO_POSITION
import kotlinx.android.synthetic.main.movie_list_item_left.view.*
import androidx.recyclerview.widget.DefaultItemAnimator
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder


class MyMovieListAdapter(var movieList: ArrayList<MovieData>, var posterTable: MutableMap<String, Int>
) : RecyclerView.Adapter<MyMovieListAdapter.MovieViewHolder>() {
    var myListener:MyItemClickListener? = null
    var lastPosition=-1

    lateinit var movie:MovieData
    var posterid: Int? = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View
        view=when(viewType){
            1 -> {
                layoutInflater.inflate(R.layout.movie_list_item_right,parent,false)
            }
            2 -> {
                layoutInflater.inflate(R.layout.movie_list_item_left,parent,false)
            }
            else->{
                layoutInflater.inflate(R.layout.movie_list_item_right,parent,false)
            }
        }

        return MovieViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if(movieList[position].vote_average>8){
            return 1
        }
        else{
            return 2
        }
    }
    inner class MovieViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val rVMovieTitle= view?.rVTitle
        val rVOverview= view?.rVOverview
        val rVposterid= view?.rVPosterid
        val rVRating= view?.rVRating
        val rVCheckBox= view?.rVCheckBox
        init{
            rVCheckBox?.setOnCheckedChangeListener { rVCheckBox,isChecked->
                movieList[this.adapterPosition].checked=isChecked

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
//        setAnimation(holder.itemView, position)


    }
    fun setAnimation(view:View,position:Int){
        if(position!=lastPosition){
            val animation = AnimationUtils.loadAnimation(view.context, android.R.anim.slide_in_left)
            animation.duration = 700
            animation.startOffset = position * 100L
            view.startAnimation(animation)
        }
        lastPosition = position
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
            notifyItemChanged(i)
        }
//        notifyDataSetChanged()

    }
    fun setClearAll() {
        for( i in movieList.indices){
            movieList[i].checked = false
            notifyItemChanged(i)
        }
//        notifyDataSetChanged()
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
//        notifyDataSetChanged()
//        notifyItemRemoved()
    }
    fun duplicateMovie(position: Int){

        var movie=movieList[position].copy()
        movieList.add(position+1,movie)
        notifyItemInserted(position+1)
//        notifyDataSetChanged()

    }


}




