

package com.onimus.blablasocialmedia.mvvm.ui.resetpass.reset

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onimus.blablasocialmedia.mvvm.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class ResetViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ResetViewModel(repository) as T
    }

}