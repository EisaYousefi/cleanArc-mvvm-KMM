package com.efb.cleanarc_mvvm_kmm.domian.repository

import com.efb.cleanarc_mvvm_kmm.domian.model.ItemResponse

interface GithubRepository {
    suspend fun getRepos(): List<ItemResponse>
}