package syr.project.homework_4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_recycler_view.*

class RecyclerViewFragment(val movieList: List<MovieData>, val posterTable: MutableMap<String, Int>) : Fragment(),
    MyMovieListAdapter.MyItemClickListener{
    private var listener: OnRecyclerInteractionListener? = null

    override fun onItemClickedFromAdapter(movie: MovieData, posterid: Int?) {
        onItemClickedFromRecyclerViewFragment(movie,posterid)
    }
    interface OnRecyclerInteractionListener {
        fun onItemClicked(movie: MovieData,posterid: Int?)
    }
    fun onItemClickedFromRecyclerViewFragment(movie: MovieData,posterid: Int?) {
        listener?.onItemClicked(movie,posterid)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager= GridLayoutManager(context,1)
        val myAdapter= MyMovieListAdapter(movieList,posterTable)
        myAdapter.setMyItemClickListener(this)
        recyclerView.adapter=myAdapter
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnRecyclerInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnRecyclerInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


//    companion object {
//
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            RecyclerViewFragment(movieList, posterTable).apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}