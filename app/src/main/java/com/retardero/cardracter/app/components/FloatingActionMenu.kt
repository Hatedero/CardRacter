package com.retardero.cardracter.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.retardero.cardracter.ui.theme.Primary

@Composable
fun FloatingActionMenu(
    closedIcon: ImageVector,
    options: Map<ImageVector, () -> Unit>
) {
    var open by remember { mutableStateOf((false)) }

    Column(
        modifier = Modifier.background(Color.Transparent)
    ) {
        if(open) {
            Column ( ) {
                options.forEach { option ->
                    SmallFloatingActionButton(
                        onClick =  option.value ,
                        containerColor = Color.LightGray,
                        content = { Icon(
                            imageVector = option.key,
                            contentDescription = "icon",
                            tint = Primary,
                        ) },
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        FloatingActionButton(
            onClick = { open = !open},
            containerColor = Color.LightGray,
            content = { Icon(
                imageVector = if (!open) closedIcon else Icons.Default.Close,
                contentDescription = "icon",
                tint = Primary,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
            ) }
        )
    }
}