package com.acm.umssconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.acm.umssconf.model.Conference
import com.acm.umssconf.network.Callback
import com.acm.umssconf.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel {
    val firestoreService = FirestoreService()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }

    private fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Conference>>{
            override fun onSuccess(result: List<Conference>) {
                listSchedule.postValue(result)
                processFinished()
            }
            override fun onFailed(exception: Exception){
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}