package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theodo.apps.ipedis.accessibility.navigation.Forms
import com.theodo.apps.ipedis.accessibility.ui.components.CustomTopAppBar
import com.theodo.apps.ipedis.accessibility.ui.theme.IpedisAndroidAccessibilityCourseTheme

@Composable
fun FormsScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        CustomTopAppBar(
            title = {
                Text(Forms.title, Modifier)
            },
            modifier = Modifier,
            navigationIcon = { },
            actions = { }
        )

        var textFieldValue by remember { mutableStateOf("") }
        val badErrorText = "Le champ email est en erreur"
        val betterErrorText = "Le champ email est obligatoire. Format attendu : nom@mail.com"
        CustomTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Email") },
            supportingText = { Text(badErrorText) },
            isError = true,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        var textFieldPhoneValue by remember { mutableStateOf("") }

        TextField(
            value = textFieldPhoneValue,
            onValueChange = { textFieldPhoneValue = it },
            label = { Text("Telephone") },
            supportingText = { Text("Le numéro de téléphone doit contenir exactement 10 chiffres") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    Column(modifier) {
        label?.invoke()

        TextField(
            modifier = Modifier,
            value = value,
            onValueChange = onValueChange,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions
        )

        if (isError) {
            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.error) {
                supportingText?.invoke()
            }
        } else {
            supportingText?.invoke()
        }
    }
}

@Preview
@Composable
private fun FormsScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    FormsScreen()
}
