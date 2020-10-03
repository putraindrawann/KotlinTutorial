package com.example.kotlintutorial

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorial.adapter.MovieAdapter
import com.example.kotlintutorial.listener.OnItemClickListener
import com.example.kotlintutorial.model.Movie
import kotlinx.android.synthetic.main.fragment_explore.*


class ExploreFragment : Fragment() {

    lateinit var movieAdapter: MovieAdapter
    val lm = LinearLayoutManager(activity)
    val addMovieList: MutableList<Movie> = ArrayList()
    var isLoading = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        action()
    }

    fun initView() {
        rv_movie.layoutManager = lm
        movieAdapter = MovieAdapter(activity!!)
        rv_movie.adapter = movieAdapter

        addMovieList.add(Movie("Movie 1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        addMovieList.add(Movie("Movie 2", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        addMovieList.add(Movie("Movie 3", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        addMovieList.add(Movie("Movie 4", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        addMovieList.add(Movie("Movie 5", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        addMovieList.add(Movie("Movie 6", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))


        movieAdapter.setMovie(addMovieList)
    }

    fun action() {
        movieAdapter.setOnClickItemListener(object : OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, MovieDetailActivity::class.java)
                i.putExtra("title", movieAdapter.getMovies().get(position).getTitle())
                i.putExtra("description", movieAdapter.getMovies().get(position).getDescription())
                startActivity(i)
            }

        })

        rv_movie.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {


                if (dy > 0) {
                    var vItem = lm.childCount
                    var lItem = lm.findFirstCompletelyVisibleItemPosition()
                    var count = movieAdapter.itemCount

                    if (!isLoading) {
                        if (vItem + lItem >= count) {
                            addMoreData()
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    fun addMoreData() {
        isLoading = true
        pg_bar.visibility = View.VISIBLE
        for (i in 0..6) {
            addMovieList.add(Movie("Movie ke "+ i + "", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "))
        }

        Handler().postDelayed({
            isLoading = false
            pg_bar.visibility = View.GONE
            movieAdapter.setMovie(addMovieList)
        },3000)
    }
}
