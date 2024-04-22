package com.theapplication.fooddelivery.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.theapplication.fooddelivery.R
import com.theapplication.fooddelivery.ui.theme.Orange
import com.theapplication.fooddelivery.ui.theme.ubuntuFont


@Composable
fun OnboardingScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(id = R.drawable.sides_2), contentDescription =null, modifier = Modifier.size(150.dp).clip(
                CircleShape), contentScale = ContentScale.Crop )

            Text(text = "Yummies", fontSize = 42.sp, fontFamily = ubuntuFont, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Tasty meals delivered to \n your doorstep", color = Color.White, textAlign = TextAlign.Center, fontSize = 14.sp, fontFamily = ubuntuFont)
            Spacer(modifier = Modifier.height(10.dp))

            Button(modifier = Modifier.width(300.dp), colors = ButtonDefaults.buttonColors(Orange), onClick = {
                navController.navigate("auth")
            }) {
                Text(text = "Get Started", color = Color.White)
            }
        }
    }



}