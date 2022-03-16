package com.revature.listviewexample.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun cardViewCallBack(context: Context,message:String){
    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
}

@Composable
fun plantCard(name:String,description:String,image:Int){

    Log.d("Card","Card Initialization")

    var context = LocalContext.current

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(100.dp)
        .wrapContentHeight()
        .clickable { cardViewCallBack(context = context,
                                    message = "$name\n$description") },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(painter = painterResource(id = image),
                contentDescription = "Plant Image",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit)

            Column(modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Text(name,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(bottom = 8.dp))

                Text(description,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onSurface)
            }
        }
    }
}
