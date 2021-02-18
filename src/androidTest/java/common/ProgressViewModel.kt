

package com.onimus.blablasocialmedia.mvvm.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class ProgressViewModel : ViewModel() {

    //create livedata variable to save the progressbar(dialog) state
    private val progressBarActive = MutableLiveData<Boolean>(false)

    /**
     * get status from viewmodel
     */
    fun getProgressBarStatus(): LiveData<Boolean> {
        return progressBarActive
    }

    /**
     *   save status to viewmodel
     */
    fun setProgressBarStatus(status: Boolean) {
        progressBarActive.postValue(status)
    }
}