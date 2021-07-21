package com.bakharaalief.requetapisederhana.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakharaalief.requetapisederhana.data.model.Post
import com.bakharaalief.requetapisederhana.data.api.ServiceBuilder
import kotlinx.coroutines.launch

class MainVM : ViewModel() {

    private val _listPost = MutableLiveData<List<Post>>()
    val listPost = _listPost

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    fun getData(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val data = ServiceBuilder.createService.getPost()
                if(data.isEmpty()){
                    _listPost.value = arrayListOf()
                }
                else{
                    _listPost.value = data
                }
            }
            catch (e:Exception){
                _listPost.value = arrayListOf()
            }

            _isLoading.value = false
        }
    }
}