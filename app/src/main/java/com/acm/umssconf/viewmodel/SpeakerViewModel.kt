package com.acm.umssconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.acm.umssconf.model.Conference
import com.acm.umssconf.model.Speaker
import com.acm.umssconf.network.Callback
import com.acm.umssconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel {
    val firestoreService = FirestoreService()
    var listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakerFromFirebase()
    }

    private fun getSpeakerFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>) {
                listSpeaker.postValue(result)
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