
package com.onimus.blablasocialmedia.mvvm.ui.auth.login

import com.onimus.blablasocialmedia.mvvm.common.AuthenticationListener

interface LoginListener : AuthenticationListener {
    fun onClickTextViewRegister() {}
    fun onClickTextViewForgotPassword() {}
    fun onSuccessGoogleSign()
}