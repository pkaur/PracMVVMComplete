package com.puneetkaur.pracmvvmcomplete.utils

sealed class Result<T>(val data: T? = null, val message: String?=null){

    class Loading<T>: Result<T>()
    class Success<T>(data: T): Result<T>(data=data)
    class Failure<T>(errorMessage: String): Result<T>(message = errorMessage)

}
