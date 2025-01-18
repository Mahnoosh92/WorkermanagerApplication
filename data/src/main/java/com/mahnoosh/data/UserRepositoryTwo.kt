package com.mahnoosh.data

import jakarta.inject.Inject
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList

class UserRepositoryTwo @Inject constructor(val userDao: UserDao) : Syncable {
    fun getUsers() = listOf(User("mahshad"))

    suspend fun addUser(users: User) = userDao.insertAll(users.toUserEntity())
    override suspend fun syncWith(synchronizer: Synchronizer): Boolean {
        return synchronizer.changeListSync(dataFetcher = {
            getUsers()
        }, modelUpdater = { userList ->
            addUser(userList[0])
        })
    }
}
