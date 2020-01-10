package com.huhuanpu.codelabdatabindingdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by huhuanpu on 20-1-10
 */

class SimpleViewModelSolution : ViewModel() {
    private val _name = MutableLiveData("Ada")
    private val _lastName = MutableLiveData("Lovelace")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

    fun onLike() {
        /*
         Elvis 操作符 ?:
         如果 ?: 左侧表达式非空, elvis 操作符就返回其左侧表达式,否则返回右侧表达式。 请注意,当且仅当左侧为空时,才会对右侧表达式求值
         */
        _likes.value = (_likes.value ?: 0) + 1
    }


}