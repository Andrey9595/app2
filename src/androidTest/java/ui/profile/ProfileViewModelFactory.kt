
package com.onimus.blablasocialmedia.mvvm.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onimus.blablasocialmedia.mvvm.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }

}