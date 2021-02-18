

package com.onimus.blablasocialmedia.mvvm.data.repository

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.onimus.blablasocialmedia.mvvm.data.firebase.FirebaseManager
import com.onimus.blablasocialmedia.mvvm.exception.InvalidEmailAndPasswordException
import com.onimus.blablasocialmedia.mvvm.utils.HandleErrors
import io.reactivex.Completable

class UserRepository(private val firebase: FirebaseManager) {

    val currentUser: FirebaseUser?
        get() = firebase.currentUser()

    private val handleErrors = HandleErrors()

    fun registerUser(email: String?, password: String?): Completable {

        return try {
            val checkEmail = handleErrors.filterEmail(email)
            val checkPassword = handleErrors.filterPassword(password)
            firebase.registerUser(checkEmail, checkPassword)

        } catch (e: InvalidEmailAndPasswordException) {
            Completable.error(e)
        }

    }

    fun logInUser(email: String?, password: String?): Completable {
        return try {
            val checkEmail = handleErrors.filterEmail(email)
            val checkPassword = handleErrors.filterPassword(password)
            firebase.logInUser(checkEmail, checkPassword)
        } catch (e: InvalidEmailAndPasswordException) {
            Completable.error(e)
        }
    }

    fun logInUser(credential: AuthCredential) = firebase.logInUser(credential)

    fun googleSignIn(task: Task<GoogleSignInAccount>) =
        firebase.googleSignInAccount(task)

    fun resetPassword(email: String?): Completable {
        return try {
            val checkEmail = handleErrors.filterEmail(email)
            firebase.resetPassword(checkEmail)
        } catch (e: InvalidEmailAndPasswordException) {
            Completable.error(e)
        }
    }

    fun logout() = firebase.logout()
}