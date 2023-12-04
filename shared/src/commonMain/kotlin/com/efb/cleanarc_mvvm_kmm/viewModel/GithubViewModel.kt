package com.efb.cleanarc_mvvm_kmm.viewModel

import com.efb.cleanarc_mvvm_kmm.domian.model.ItemResponse
import com.efb.cleanarc_mvvm_kmm.domian.model.getMockResponses
import com.efb.cleanarc_mvvm_kmm.domian.secase.GetRepos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GithubViewModel(private val getRepos: GetRepos) : SharedViewModel() {

    private val _items = MutableStateFlow<List<ItemResponse>>(listOf())
    val items = _items.asStateFlow()

    init {
        sharedViewModelScope.launch {
            kotlin.runCatching {
                getRepos.invoke()
            }.onSuccess {
                _items.update { getMockResponses() }
            }.onFailure {
                println(it.message)
            }
        }
    }

}