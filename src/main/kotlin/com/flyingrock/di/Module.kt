package com.flyingrock.di

import com.flyingrock.db.UserRepositoryImpl
import com.flyingrock.db.dao.UserDao
import com.flyingrock.db.dao.UserDaoImpl
import com.flyingrock.domain.user.UserRepository
import com.flyingrock.domain.user.UserService
import com.flyingrock.domain.user.UserServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::UserServiceImpl) bind UserService::class

    singleOf(::UserDaoImpl) bind UserDao::class

    singleOf(::UserRepositoryImpl) bind UserRepository::class

}