package com.efb.cleanarc_mvvm_kmm.data

import com.efb.cleanarc_mvvm_kmm.domian.model.ItemResponse
import com.efb.cleanarc_mvvm_kmm.domian.repository.GithubRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class GithubRepositoryImpl(private val httpClient: HttpClient) :GithubRepository{
    override suspend fun getRepos(): List<ItemResponse> {
        return try {
            httpClient.get(urlString = "orgs/android/repos").body()
        } catch (e: Exception) {
            println(e.message)
            emptyList()

        }
    }

}