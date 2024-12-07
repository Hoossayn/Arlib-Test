package com.example.login.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.ui.component.CustomButton
import com.example.core.ui.component.CustomTextField
import com.example.login.R
import com.example.login.viewmodel.LoginViewModel

const val LOGIN_BUTTON_TEST_TAG = "login_button"

@Composable
fun LoginScreen (
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClicked:(name: String) -> Unit
) {
    LoginScreen(
        onLoginClicked = onLoginClicked
    )

}

@Composable
fun LoginScreen(
    onLoginClicked: (name: String) -> Unit = {}
) {

    var username by remember { mutableStateOf(" ") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.login),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = stringResource(R.string.welcome_back),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.signin_with_username_and_pass),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomTextField(
            trailingIcon = R.drawable.mail,
            label = stringResource(R.string.username),
            keyboardType = KeyboardType.Email,
            visualTransformation = VisualTransformation.None,
            onChange = { newEmail -> username = newEmail.text }
        )
        Spacer(modifier = Modifier.height(20.dp))
        CustomTextField(
            trailingIcon = R.drawable.lock,
            label = stringResource(R.string.password),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            onChange = { newPass -> password = newPass.text }
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            shapeSize = 50f,
            btnText = stringResource(R.string.login),
            onClick = { onLoginClicked(username) },
            modifier = Modifier.testTag(LOGIN_BUTTON_TEST_TAG)
        )
    }
}


