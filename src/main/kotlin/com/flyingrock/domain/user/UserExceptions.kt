package com.flyingrock.domain.user

sealed class UserException(val errorCode: Int, message: String): Exception(message)
class UserRegisteredException : UserException(
    ERROR_CODE,
    "The user has registered"
) {
    companion object {
        const val ERROR_CODE = 100
    }
}

class UserNotExistException: UserException(
    ERROR_CODE,
    "The user is not existed"
) {
    companion object {
        const val ERROR_CODE = 101
    }
}
class WrongPasswordException: UserException(
    ERROR_CODE,
    "Wrong password"
) {
    companion object { const val ERROR_CODE = 102 }
}