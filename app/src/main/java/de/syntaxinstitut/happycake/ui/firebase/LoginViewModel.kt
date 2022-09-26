package de.syntaxinstitut.happycake.ui.firebase

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

const val TAG="MAINVIEWMODEL"

class LoginViewModel(application: Application): AndroidViewModel (application){

    private val firebaseAuth = FirebaseAuth.getInstance()

    private val  _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
    get() = _currentUser

    fun signUp (email:String, password:String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            if(it.isSuccessful){
                login(email, password)
            }else{
                Log.e(TAG,"SignUp failed:${it.exception}")
            }
        }
    }
fun login(email:String, password: String){
    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
        if(it.isSuccessful){
            _currentUser.value = firebaseAuth.currentUser
        }else{
            Log.e(TAG,"login failed:${it.exception}")
        }
    }
}
    fun logOut(){
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }
}
