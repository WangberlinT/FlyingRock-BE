package com.flyingrock.domain


fun <T> T.toResponseBody(): ResponseBody<T> = ResponseBody(this)