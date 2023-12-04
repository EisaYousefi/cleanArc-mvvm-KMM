package com.efb.cleanarc_mvvm_kmm.viewModel

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class GithubViewModelHelper: KoinComponent {
    private val githubViewModel: GithubViewModel = get()

    @NativeCoroutinesState
    val items = githubViewModel.items
}