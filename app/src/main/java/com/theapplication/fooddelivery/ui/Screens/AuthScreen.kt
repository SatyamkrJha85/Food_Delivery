package com.theapplication.fooddelivery.ui.Screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.theapplication.fooddelivery.R
import com.theapplication.fooddelivery.ui.Component.TabLayout
import com.theapplication.fooddelivery.ui.theme.ubuntuFont

@Composable
fun AuthScreen(navController: NavController) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val selectedTab = remember {
            mutableIntStateOf(0)
        }

        TabLayout(
            selectedIndex = selectedTab.intValue,
            items =
            listOf(
                "Sign In" to { SignIn(navController = navController, sharedPreferences =sharedPreferences )},
                "Sign Up" to { SignUp(navController = navController, sharedPreferences =sharedPreferences )}
            ), onTabClick = {
                selectedTab.intValue = it
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn(navController: NavController,sharedPreferences: SharedPreferences) {
    val rememberMeChecked = remember {
        mutableStateOf(false)
    }

    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val showPassword = remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(22.dp))

        AppTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = "Email Address"
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = "Password",
            visualTransformation = if (showPassword.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            triling = {
                Icon(
                    modifier = Modifier.clickable {
                        showPassword.value = !showPassword.value
                    },
                    painter = painterResource(
                        id = if (showPassword.value)
                            R.drawable.ic_eye_off else R.drawable.ic_eye_open
                    ),
                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Forgot Password", color = Color.Gray, fontSize = 11.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides (false)) {
                Checkbox(checked = rememberMeChecked.value, onCheckedChange = {
                    rememberMeChecked.value = it
                })
            }

            Text(
                text = "Remember Me",
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
            Spacer(modifier = Modifier.height(12.dp))

            Button(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp), onClick = {
                sharedPreferences.edit().apply {
                    putBoolean("loggedIn",true)
                    putString("email",email.value)
                }
                    .apply()
                navController.navigate("home"){
                    popUpTo(0)
                }
            }, shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Login", fontFamily = ubuntuFont)
            }



    }
}

// signup


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController,sharedPreferences: SharedPreferences) {


    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val passwordRepeat = remember {
        mutableStateOf("")
    }

    val showPassword = remember {
        mutableStateOf(false)
    }

    val showPasswordRepeat = remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(22.dp))

        AppTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = "Email Address"
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = "Password",
            visualTransformation = if (showPassword.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            triling = {
                Icon(
                    modifier = Modifier.clickable {
                        showPassword.value = !showPassword.value
                    },
                    painter = painterResource(
                        id = if (showPassword.value)
                            R.drawable.ic_eye_off else R.drawable.ic_eye_open
                    ),
                    contentDescription = null
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppTextField(
            value = passwordRepeat.value,
            onValueChange = {
                passwordRepeat.value = it
            },
            label = "Repeat Password",
            visualTransformation = if (showPasswordRepeat.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            triling = {
                Icon(
                    modifier = Modifier.clickable {
                        showPasswordRepeat.value = !showPasswordRepeat.value
                    },
                    painter = painterResource(
                        id = if (showPasswordRepeat.value)
                            R.drawable.ic_eye_off else R.drawable.ic_eye_open
                    ),
                    contentDescription = null
                )
            }
        )


        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp), onClick = {
                sharedPreferences.edit().apply {
                    putBoolean("loggedIn",true)
                    putString("email",email.value)
                }
                    .apply()
                navController.navigate("home"){
                    popUpTo(0)
                }
            }, shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Register", fontFamily = ubuntuFont)
            }

        }

    }
}

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    triling: (@Composable () -> Unit)? = null
) {
    Column {
        Text(text = label)
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .shadow(3.dp, RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = value, onValueChange = onValueChange,
                visualTransformation = visualTransformation,
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,

                ), trailingIcon = triling
            )
        }
    }

}