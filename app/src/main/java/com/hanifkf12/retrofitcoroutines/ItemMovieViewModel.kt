package com.hanifkf12.retrofitcoroutines

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.hanifkf12.moviecatalogsubmission3.model.movie.Movie

class ItemMovieViewModel(data : Movie) : ViewModel(){
    var title: ObservableField<String> = ObservableField()
    var overview: ObservableField<String> = ObservableField()
    var poster: ObservableField<String> = ObservableField()
    var date: ObservableField<String> = ObservableField()


    init {
        title.set(data.title)
        overview.set(data.overview)
        poster.set(data.posterPath)
        date.set(data.releaseDate)

    }
}