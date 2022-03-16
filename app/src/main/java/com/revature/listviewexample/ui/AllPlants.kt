package com.revature.listviewexample.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.listviewexample.R
import com.revature.listviewexample.model.data.Plant
import com.revature.listviewexample.ui.theme.ListViewExampleTheme

@Preview(uiMode = UI_MODE_NIGHT_NO,
            name = "Light Mode")
@Composable
fun allPlantsPreview(){
    //enable via theme
    ListViewExampleTheme{/*(darkTheme = true)*/

        allPlants(plants = plants)
    }
}

//enable dark theme via preview
@Preview(uiMode = UI_MODE_NIGHT_YES,
            name = "Dark Mode")
@Composable
fun darkPreview(){
    ListViewExampleTheme {
        allPlants(plants = plants)
    }
}

@Composable
fun allPlants(plants: List<Plant>) {

    Log.d("List","List Initialization")

    Scaffold (
        topBar = {
            TopAppBar (
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.title))}) })

        {
        LazyColumn (
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(8.dp))

        {
            item {

                Row ( modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(stringResource(id = R.string.title),
                                    style = MaterialTheme.typography.h1,
                                    fontSize = 40.sp,
                                    fontStyle = FontStyle.Italic,
                                    color = MaterialTheme.colors.onPrimary)

                }
            }//end of item

            items(plants){
                plant->
                plantCard(plant.name,plant.Description,plant.imageRes)
            }
        }
    }
}