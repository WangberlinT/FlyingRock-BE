package com.flyingrock.domain

class InternalException(val errorCode: Int, message: String?) : Exception(message) {
    constructor(errorCode: Int): this(errorCode, null)
}