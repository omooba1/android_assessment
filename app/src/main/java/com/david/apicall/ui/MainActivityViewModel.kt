package com.david.apicall.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.david.apicall.api.RetrofitProvider
import com.david.apicall.model.Item
import com.david.apicall.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentLiveData = MutableLiveData<List<Student>>()

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            itemsLiveData.postValue(RetrofitProvider.placeHolderAPI.getItems())
        }
    }

    fun getStudents(){
        CoroutineScope(Dispatchers.IO).launch {
            studentLiveData.postValue(RetrofitProvider.placeHolderAPI.getStudent())
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentLiveData.postValue(RetrofitProvider.placeHolderAPI.addStudent(newStudent))
        }
    }


}