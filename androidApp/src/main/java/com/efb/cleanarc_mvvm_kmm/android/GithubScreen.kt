package com.efb.cleanarc_mvvm_kmm.android

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.efb.cleanarc_mvvm_kmm.domian.model.ItemResponse
import com.efb.cleanarc_mvvm_kmm.viewModel.GithubViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GithubScreen() {
    val githubViewModel: GithubViewModel = koinViewModel()
    val items by githubViewModel.items.collectAsState()
    Log.i("TAG123", "GithubScreen: ${items}")
    Scaffold { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(items.size) { index ->
                Item(items[index])
            }
        }
    }
}

@Composable
private fun Item(item: ItemResponse) {
    Column(Modifier.padding(end = 16.dp, start = 16.dp, top = 10.dp)) {
        val repo = item
        Text(text = repo.name)
        Text(
            text = stringResource(
                id = R.string.repo_info,
                repo.forks,
                repo.watchers,
                repo.openIssues
            )
        )
    }
}

