package com.efb.cleanarc_mvvm_kmm.domian.secase

import com.efb.cleanarc_mvvm_kmm.domian.repository.GithubRepository

class GetRepos(private val githubRepository: GithubRepository) {
    suspend fun invoke() = githubRepository.getRepos()
}