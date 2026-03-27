package com.theodo.apps.ipedis.accessibility.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
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
        var emailError by remember { mutableStateOf(false) }
        val badErrorText = "Le champ email est en erreur"
        val betterErrorText = "Le champ email est obligatoire. Format attendu : nom@mail.com"
        CustomTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            label = { Text("Email") },
            supportingText = { if (emailError) Text(betterErrorText) else null },
            isError = emailError,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        var textFieldPhoneValue by remember { mutableStateOf("") }
        var phoneError by remember { mutableStateOf(false) }

        CustomTextField(
            value = textFieldPhoneValue,
            onValueChange = { textFieldPhoneValue = it },
            label = { Text("Telephone") },
            supportingText = { if (phoneError) Text("Le numéro de téléphone doit contenir exactement 10 chiffres") else null },
            isError = phoneError,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        var sent by remember { mutableStateOf(false) }
        val context = LocalContext.current
        val sentText = "Formulaire enregistré avec succès"
        Button(
            onClick = {
                validateForm(textFieldValue, textFieldPhoneValue)
            },
            modifier = Modifier.padding(16.dp),
            enabled = !sent
        ) {
            Text("Envoyer")
        }

        if (sent) {
            Text(
                text = sentText,
                modifier = Modifier.padding(16.dp)
            )
        }
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
    keyboardActions: KeyboardActions = KeyboardActions.Default
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

fun validateForm(email: String, phone: String) {
    emailError = email.isEmpty() || !email.contains("@")
    phoneError = phone.length != 10
    if (emailError) {
        // Give focus to the email field
    } else if (phoneError) {
        // Give focus to the phone field
    } else {
        sent = true
    }
}

@Preview
@Composable
private fun FormsScreenPreview() = IpedisAndroidAccessibilityCourseTheme {
    FormsScreen()
}
