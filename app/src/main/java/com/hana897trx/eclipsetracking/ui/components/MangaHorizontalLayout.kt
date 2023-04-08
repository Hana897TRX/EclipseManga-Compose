package com.hana897trx.eclipsetracking.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MangaHorizontalLayout() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "MangaHorizontalLayout")
        LazyRow() {
            items(10) {
                MangaComponent()
            }
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFF000000)
fun MangaHorizontalLayoutPreview() {
    MangaHorizontalLayout()
}