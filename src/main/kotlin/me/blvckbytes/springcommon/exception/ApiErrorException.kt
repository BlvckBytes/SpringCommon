package me.blvckbytes.springcommon.exception

import me.blvckbytes.springcommon.config.ApiError

abstract class ApiErrorException : RuntimeException() {

  abstract fun getApiError(): ApiError

}