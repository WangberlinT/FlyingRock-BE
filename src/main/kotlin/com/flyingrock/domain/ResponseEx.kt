package com.flyingrock.handler

import com.flyingrock.domain.ResponseBody


fun <T> T.toResponseBody(): ResponseBody<T> = ResponseBody(this)