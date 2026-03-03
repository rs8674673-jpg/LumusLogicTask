package com.ssti.lumuslogictask.core.common

/**
 * Author: Ravi Soni
 * Date: Mar 3, 2026
 * Desc: Sealed class representing loading, success, or error states.
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

