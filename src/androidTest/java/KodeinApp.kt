

package com.onimus.blablasocialmedia.mvvm

import android.app.Application
import com.onimus.blablasocialmedia.mvvm.data.firebase.FirebaseManager
import com.onimus.blablasocialmedia.mvvm.data.repository.UserRepository
import com.onimus.blablasocialmedia.mvvm.ui.auth.login.LoginViewModelFactory
import com.onimus.blablasocialmedia.mvvm.ui.auth.main.MainViewModelFactory
import com.onimus.blablasocialmedia.mvvm.ui.auth.register.RegisterViewModelFactory
import com.onimus.blablasocialmedia.mvvm.ui.profile.ProfileViewModelFactory
import com.onimus.blablasocialmedia.mvvm.ui.resetpass.reset.ResetViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KodeinApp : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@KodeinApp))

        bind() from singleton { FirebaseManager() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { MainViewModelFactory(instance()) }
        bind() from provider { LoginViewModelFactory(instance()) }
        bind() from provider { RegisterViewModelFactory(instance()) }
        bind() from provider { ResetViewModelFactory(instance()) }
    }
}