package com.chaos.asratly.ui.component;

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.chaos.asratly.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController, onBellClick: () -> Unit = {}) {
    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        //navigationIcon = { },
        actions = {
            IconButton(onClick = onBellClick) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notifications"
                )
            }
        }
    )
}
