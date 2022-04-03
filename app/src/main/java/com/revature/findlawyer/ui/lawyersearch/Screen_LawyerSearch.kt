package com.revature.findlawyer.ui.lawyersearch

import android.os.Bundle
import android.widget.RatingBar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.ui.BottNavBar
import com.revature.findlawyer.ui.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel


@Composable
fun Screen_LawyerSearch(navHostController: NavHostController,viewModel: FetchLawyersViewModel) {
    val context = LocalContext.current
    viewModel.lawyersList()
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = MaterialTheme.colors.primary,
                title = {Text("Lawyer Search")})
        },
        bottomBar = {
            BottNavBar(navHostController)
        }
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            item {
                Row() {
                    filter1Menu()
                    filter2Menu()
                }
                Row {
                }
                Row {

                }

            }
            items(viewModel.lawyerResultList.value) { lawyer ->
                LawyerCard(navHostController = navHostController, fetchLawyersViewModel = viewModel, firstName = lawyer.firstName, lastName = lawyer.lastName,
                    typeOfPractice = lawyer.typeOfPractice, rating = lawyer.rating,
                    image = lawyer.img, numCases = lawyer.numOfCases, id = lawyer.id)
            }
        }
    }
}

@Composable
fun filter1Menu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("All","Rating - High to Low", "Alphabetical (A-Z)", "Alphabetical (Z-A)", "Case Count - High to Low")
    var selectedText by remember { mutableStateOf("All") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column() {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .padding(10.dp)
                .width(175.dp)
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("Filter")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            readOnly = true,
            singleLine = true
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}

@Composable
fun filter2Menu() {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("All","Criminal Defense", "Civil Attorney", "Worker's Compensation",
        "Personal Injury")
    var selectedText by remember { mutableStateOf("All") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown


    Column() {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .padding(10.dp)
                .width(175.dp)
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = {Text("Type")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            },
            readOnly = true,
            singleLine = true
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current){textfieldSize.width.toDp()})
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }

}









@Preview
@Composable
fun testLawyerSearch() {
//    Screen_LawyerSearch()
}

