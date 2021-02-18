
package com.onimus.blablasocialmedia.mvvm.common

interface AuthenticationListener {
    fun onSuccessAuth()
    fun onFailureAuth(resId: Int)
    fun inEmailValidationError(resId: Int)
    fun inPasswordValidationError(resId: Int) {}
    //
    fun showProgress()
    fun hideProgress()
    fun resetTextInputLayout()
}