package com.huhuanpu.codelabdatabindingdemo.data

import androidx.lifecycle.ViewModel

/**
 * Created by huhuanpu on 20-1-10
 */


class SimpleViewModel : ViewModel() {
    val name = "Grace"
    val lastName = "Hopper"
    var likes = 0
    private set //this is to prevent external modification of the variable

    /**
     * Increments the number of likes
     */

    fun onLike() {
        likes++
    }

    /**
     * Return popularity in buckets
     */
    val popularity: Popularity
    get() {
        return when {
            likes > 9 -> Popularity.STAR
            likes > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

}
enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}