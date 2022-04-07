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
import com.revature.findlawyer.DrawerScreens
import com.revature.findlawyer.data.network.Lawyer
import com.revature.findlawyer.ui.BottNavBar
import com.revature.findlawyer.ui.ui.theme.FindLawyerTheme
import com.revature.findlawyer.viewmodel.FetchLawyersViewModel


@Composable
fun Screen_LawyerSearch(navHostController: NavHostController,viewModel: FetchLawyersViewModel) {
    val context = LocalContext.current
    var sortExpanded by remember { mutableStateOf(false) }
    val sortFilterOpt = listOf("All","Rating - High to Low", "Alphabetical (A-Z)", "Alphabetical (Z-A)", "Case Count - High to Low")
    var selectedSort by remember { mutableStateOf(viewModel.getSortFilter()) }
    var sortTextfieldSize by remember { mutableStateOf(Size.Zero)}
    val sortIcon = if (sortExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    var typeExpanded by remember { mutableStateOf(false) }
    val lawyerTypes = listOf("All","Criminal Defense", "Civil Attorney", "Worker's Compensation",
        "Personal Injury")
    var selectedType by remember { mutableStateOf(viewModel.getTypeFilter()) }
    var typeTextfieldSize by remember { mutableStateOf(Size.Zero)}
    val icon = if (typeExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    //load list from API service
    viewModel.lawyersList()
    var filteredList = viewModel.lawyerResultList.value

    //apply filters
    when(selectedType) {
        "Criminal Defense" -> filteredList = filteredList.filter { it.typeOfPractice == "Criminal Defense" }
        "Civil Attorney"-> filteredList = filteredList.filter { it.typeOfPractice == "Civil Attorney" }
        "Worker's Compensation"-> filteredList = filteredList.filter { it.typeOfPractice == "Worker's Compensation" }
        "Personal Injury"-> filteredList = filteredList.filter { it.typeOfPractice == "Personal Injury" }
    }

    when(selectedSort) {
        "Rating - High to Low" -> filteredList = filteredList.sortedByDescending { it.rating }
        "Alphabetical (A-Z)"-> filteredList = filteredList.sortedBy { it.lastName }
        "Alphabetical (Z-A)"-> filteredList = filteredList.sortedByDescending { it.lastName }
        "Case Count - High to Low"-> filteredList = filteredList.sortedByDescending { it.numOfCases }
    }


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
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.8f),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
        ) {
            item {
                Row() {
                    Column() {
                        OutlinedTextField(
                            value = selectedSort,
                            onValueChange = { selectedSort = it },
                            modifier = Modifier
                                .padding(10.dp)
                                .width(175.dp)
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    sortTextfieldSize = coordinates.size.toSize()
                                },
                            label = {Text("Sort")},
                            trailingIcon = {
                                Icon(sortIcon,"contentDescription",
                                    Modifier.clickable { sortExpanded = !sortExpanded })
                            },
                            readOnly = true,
                            singleLine = true
                        )
                        DropdownMenu(
                            expanded = sortExpanded,
                            onDismissRequest = { sortExpanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current){sortTextfieldSize.width.toDp()})
                        ) {
                            sortFilterOpt.forEach { label ->
                                DropdownMenuItem(onClick = {
                                    selectedSort = label
                                    sortExpanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                    }

                    Column() {
                        OutlinedTextField(
                            value = selectedType,
                            onValueChange = { selectedType = it },
                            modifier = Modifier
                                .padding(10.dp)
                                .width(175.dp)
                                .onGloballyPositioned { coordinates ->
                                    //This value is used to assign to the DropDown the same width
                                    typeTextfieldSize = coordinates.size.toSize()
                                },
                            label = {Text("Type")},
                            trailingIcon = {
                                Icon(icon,"contentDescription",
                                    Modifier.clickable { typeExpanded = !typeExpanded })
                            },
                            readOnly = true,
                            singleLine = true
                        )
                        DropdownMenu(
                            expanded = typeExpanded,
                            onDismissRequest = { typeExpanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current){typeTextfieldSize.width.toDp()})
                        ) {
                            lawyerTypes.forEach { label ->
                                DropdownMenuItem(onClick = {
                                    selectedType = label
                                    typeExpanded = false
                                }) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                }
            }


            items(filteredList) { lawyer ->
                LawyerCard(navHostController = navHostController, fetchLawyersViewModel = viewModel, firstName = lawyer.firstName, lastName = lawyer.lastName,
                    typeOfPractice = lawyer.typeOfPractice, rating = lawyer.rating,
                    image = lawyer.img, numCases = lawyer.numOfCases, id = lawyer.id)
            }
        }
    }
}











//@Composable
//fun filter1Menu() {
//
//    var sortExpanded by remember { mutableStateOf(false) }
//    val sortFilterOpt = listOf("All","Rating - High to Low", "Alphabetical (A-Z)", "Alphabetical (Z-A)", "Case Count - High to Low")
//    var selectedSort by remember { mutableStateOf("All") }
//    var sortTextfieldSize by remember { mutableStateOf(Size.Zero)}
//    val sortIcon = if (sortExpanded)
//        Icons.Filled.KeyboardArrowUp
//    else
//        Icons.Filled.KeyboardArrowDown
//
//
//    Column() {
//        OutlinedTextField(
//            value = selectedSort,
//            onValueChange = { selectedSort = it },
//            modifier = Modifier
//                .padding(10.dp)
//                .width(175.dp)
//                .onGloballyPositioned { coordinates ->
//                    //This value is used to assign to the DropDown the same width
//                    sortTextfieldSize = coordinates.size.toSize()
//                },
//            label = {Text("Sort")},
//            trailingIcon = {
//                Icon(sortIcon,"contentDescription",
//                    Modifier.clickable { sortExpanded = !sortExpanded })
//            },
//            readOnly = true,
//            singleLine = true
//        )
//        DropdownMenu(
//            expanded = sortExpanded,
//            onDismissRequest = { sortExpanded = false },
//            modifier = Modifier
//                .width(with(LocalDensity.current){sortTextfieldSize.width.toDp()})
//        ) {
//            sortFilterOpt.forEach { label ->
//                DropdownMenuItem(onClick = {
//                    selectedSort = label
//                    sortExpanded = false
//                }) {
//                    Text(text = label)
//                }
//            }
//        }
//    }
//
//}
//
//@Composable
//fun filter2Menu() {
//
//    var typeExpanded by remember { mutableStateOf(false) }
//    val lawyerType = listOf("All","Criminal Defense", "Civil Attorney", "Worker's Compensation",
//        "Personal Injury")
//    var selectedType by remember { mutableStateOf("All") }
//    var typeTextfieldSize by remember { mutableStateOf(Size.Zero)}
//    val icon = if (typeExpanded)
//        Icons.Filled.KeyboardArrowUp
//    else
//        Icons.Filled.KeyboardArrowDown
//
//
//    Column() {
//        OutlinedTextField(
//            value = selectedType,
//            onValueChange = { selectedType = it },
//            modifier = Modifier
//                .padding(10.dp)
//                .width(175.dp)
//                .onGloballyPositioned { coordinates ->
//                    //This value is used to assign to the DropDown the same width
//                    typeTextfieldSize = coordinates.size.toSize()
//                },
//            label = {Text("Type")},
//            trailingIcon = {
//                Icon(icon,"contentDescription",
//                    Modifier.clickable { typeExpanded = !typeExpanded })
//            },
//            readOnly = true,
//            singleLine = true
//        )
//        DropdownMenu(
//            expanded = typeExpanded,
//            onDismissRequest = { typeExpanded = false },
//            modifier = Modifier
//                .width(with(LocalDensity.current){typeTextfieldSize.width.toDp()})
//        ) {
//            lawyerType.forEach { label ->
//                DropdownMenuItem(onClick = {
//                    selectedType = label
//                    typeExpanded = false
//                }) {
//                    Text(text = label)
//                }
//            }
//        }
//    }
//
//}









@Preview
@Composable
fun testLawyerSearch() {
//    Screen_LawyerSearch()
}

