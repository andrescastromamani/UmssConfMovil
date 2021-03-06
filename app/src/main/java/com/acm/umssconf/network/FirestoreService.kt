package com.acm.umssconf.network

import com.acm.umssconf.model.Conference
import com.acm.umssconf.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import javax.security.auth.callback.Callback

const val CONFERENCES_COLLETION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"
class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }
    fun getSpeakers(callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
    fun getSchedule(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result){
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}