
package com.onimus.blablasocialmedia.mvvm.ui.profile

import androidx.lifecycle.ViewModel
import com.onimus.blablasocialmedia.mvvm.data.repository.UserRepository

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {

    var profileListener: ProfileListener? = null

    val user by lazy {
        repository.currentUser
    }

    fun checkUserStatus() {
        if (user == null) {
            //user signout
            profileListener?.onLogout()
        }
    }

    fun onClickButtonLogout(){
        repository.logout()
        profileListener?.onLogout()

    }
}
