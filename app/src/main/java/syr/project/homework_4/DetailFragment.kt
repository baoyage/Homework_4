package syr.project.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_detail.*
import java.io.Serializable

private const val ARG_MOV1 = "movie"
private const val ARG_MOV2 = "posterid"
class DetailFragment : Fragment() {

    private var movie: MovieData? = null
    private var posterid:Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getSerializable(ARG_MOV1) as MovieData
            posterid = it.getInt(ARG_MOV2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieTitle.text=movie!!.title
        release_date.text=movie!!.release_date
        stars.text=movie!!.stars
        ratingBar.rating= movie!!.vote_average.toFloat()/2
        overview.text=movie!!.overview
        poster.setImageResource(posterid)
    }
    companion object {

        @JvmStatic
        fun newInstance(movie: MovieData, posterid: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MOV1, movie as Serializable)
                    putInt(ARG_MOV2, posterid)
                }
            }
    }
}