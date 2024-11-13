package com.theodo.apps.ipedis.accessibility.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class ArticleState {
    FAVORITE,
    ADDING_FAVORITE,
    DELETE_FAVORITE,
    NOT_FAVORITE
}

@Composable
fun CustomArticle(name: String, modifier: Modifier = Modifier) {
    var selected by remember { mutableStateOf(ArticleState.NOT_FAVORITE) }
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .toggleable(
                value = selected == ArticleState.FAVORITE,
                onValueChange = {
                    coroutineScope.launch {
                        if (selected == ArticleState.FAVORITE) {
                            selected = ArticleState.DELETE_FAVORITE
                            delay(4000)
                            selected = ArticleState.NOT_FAVORITE
                        } else if (selected == ArticleState.NOT_FAVORITE) {
                            selected = ArticleState.ADDING_FAVORITE
                            delay(4000)
                            selected = ArticleState.FAVORITE
                        }
                    }
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(name, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.width(12.dp))

            }
            Text(
                text = "Longue description pour $name sur plusieurs lignes pour un petit écran",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
        val icon = when (selected) {
            ArticleState.FAVORITE -> Icons.Default.Favorite
            ArticleState.ADDING_FAVORITE -> Icons.Default.Add
            ArticleState.DELETE_FAVORITE -> Icons.Default.Delete
            ArticleState.NOT_FAVORITE -> Icons.Default.FavoriteBorder

        }
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
private fun CustomArticlePreview() = IpedisAndroidAccessibilityCourseTheme {
    CustomArticle("Article 1")
}
