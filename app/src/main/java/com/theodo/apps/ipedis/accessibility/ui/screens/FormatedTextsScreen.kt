package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.theodo.apps.ipedis.accessibility.navigation.FormatedTexts
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun FormatedTextsScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        CustomTopAppBar(
            title = {
                Text(FormatedTexts.title, Modifier)
            },
            modifier = Modifier,
            navigationIcon = { },
            actions = { }
        )
        Row {
            Text(
                text = "Date: ",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "25 feb 24",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Row {
            Text(
                text = "Somme positive: ",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "2,03 €",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Row {
            Text(
                text = "Somme négative: ",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "- 2.03 €",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        val bankAccountNumber = BankAccountNumber("6778413027389182")
        Row {
            Text(
                text = "Numéro de compte bancaire: ",
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = bankAccountNumber.toString(),
                modifier = Modifier,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

class BankAccountNumber(private val number: String) {
    override fun toString(): String = number.replaceRange(4, number.length - 4, " xxxx xxxx ")

    fun vocalized(): String = "Compte bancaire commençant par ${
        number.substring(
            0,
            4
        )
    } et finissant par ${number.substring(number.length - 4)}"
}

@Preview
@Composable
private fun FormatedTextsScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    FormatedTextsScreen()
}
