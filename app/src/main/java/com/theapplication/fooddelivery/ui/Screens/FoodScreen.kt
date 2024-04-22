package com.theapplication.fooddelivery.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.theapplication.fooddelivery.ui.theme.ubuntuFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodScreen(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.shadow(8.dp),
                title = { Text(text = "Food", fontFamily = ubuntuFont) },
                navigationIcon = {
                    Row(
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    navController.popBackStack()
                                })
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 200.dp),
                painter = painterResource(id = foods.random().image),
                contentDescription =null,
                contentScale = ContentScale.Crop
            )
            
            
            Spacer(modifier = Modifier.heightIn(16.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = foods.random().name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "187$", fontSize = 17.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Description", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "To find the portion of the cake that is finished, you add up the portions eaten by Raju and Mita" +
                        "a web hosting service which is aimed at providing free servers and tools to it's members for both personal and commercial use." ,
                    fontSize = 13.sp, textAlign = TextAlign.Justify,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Recommended Foods:", modifier = Modifier.padding(horizontal = 8.dp),
                fontWeight = FontWeight.Bold, fontSize = 17.sp)

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(foods){food->
                    RecommendedFood(food = food, onTap = {food->

                    })
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(thickness = 2.dp)
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(text = "Rating & Reviews", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "To find the portion of the cake that is finished, you add up the portions eaten by Raju and Mita" +
                        "a web hosting service which is aimed at providing free servers and tools to it's members for both personal and commercial use." ,
                    fontSize = 13.sp, textAlign = TextAlign.Justify,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))



        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendedFood(
    food:Food,onTap:(Food)->Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xfff1f1f1)
        ),
        onClick = {onTap(food)}
    ) {
        Column {
            Image(modifier = Modifier.sizeIn(maxWidth = 120.dp, maxHeight = 70.dp), painter = painterResource(
                id = food.image
            ), contentDescription =food.name )

            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = food.name, color = Color(0xff313131), fontSize = 13.sp)
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "${food.price}")
                Spacer(modifier = Modifier.height(4.dp))


            }
        }
    }
}