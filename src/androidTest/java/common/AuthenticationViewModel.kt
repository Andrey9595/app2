

package com.onimus.blablasocialmedia.mvvm.common

import com.onimus.blablasocialmedia.mvvm.exception.EmailException
import com.onimus.blablasocialmedia.mvvm.exception.PasswordException
import com.onimus.blablasocialmedia.mvvm.utils.HandleErrors
import io.reactivex.Completable
import io.reactivex.disposables.Disposable

abstract class AuthenticationViewModel : ProgressViewModel() {


    protected fun <T : AuthenticationListener> disposableToAuthentication(
        completable: Completable,
        listener: T,
        handleErrors: HandleErrors
    ): Disposable {
        listener.showProgress()
        //calling repository to perform the actual authentication
        return completable
            .subscribe({
                listener.hideProgress()
                listener.onSuccessAuth()
            }, {

                listener.hideProgress()

                val error = handleErrors.getMessageError(it)

                when (it) {
                    //Show message in text input
                    is EmailException -> listener.inEmailValidationError(error)
                    //Show message in text input
                    is PasswordException -> listener.inPasswordValidationError(error)
                    //show message
                    else -> listener.onFailureAuth(error)
                }
            })
    }

}