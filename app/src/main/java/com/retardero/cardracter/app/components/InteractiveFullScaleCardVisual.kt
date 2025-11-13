//package com.retardero.cardracter.app.components
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldColors
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.retardero.cardracter.R
//import com.retardero.cardracter.app.model.Card
//import com.retardero.cardracter.app.model.CustomAttribute
//import com.retardero.cardracter.app.model.CustomCategory
//import com.retardero.cardracter.collections.model.ModifiableCard
//import com.retardero.cardracter.collections.model.ModifiableCustomAttribute
//import com.retardero.cardracter.collections.model.ModifiableCustomCategory
//import com.retardero.cardracter.ui.theme.Background
//import com.retardero.cardracter.ui.theme.Primary
//
//
//@Composable
//fun InteractiveFullScaleCardVisual(baseCard: ModifiableCard) {
//
//    var card by remember { mutableStateOf(baseCard) }
//
//    return when (card) {
//        is ModifiableCard.ModifiableMultiCategoryCard -> {
//
//            Column() {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Image(
//                        painter = painterResource(R.drawable.artorias),
//                        contentDescription = "icon",
//                        contentScale = ContentScale.Fit,
//                        modifier = Modifier
//                            .clip(RoundedCornerShape(10.dp))
//                            .fillMaxHeight()
//                            .clickable { card }
//                    )
//                }
//                Column(
//                    Modifier.fillMaxSize(),
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(8.dp),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        CardTitleTextField(card.cardTitle, { card.title = it })
//                        Spacer(modifier = Modifier.height(8.dp))
//                    }
//
//                    Spacer(modifier = Modifier.height(32.dp))
//
//                    card.cardAttributes.forEachIndexed { i, category ->
//                        Column (
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(8.dp),
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//
//                            CardSubTitleTextField(category.title, { card.cardAttributes[i].title = it})
//                            when (category) {
//                                is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> {
//                                    category.attributes.forEachIndexed { index, attribute ->
//                                        CardTextField(attribute.returnValue(),
//                                            {
//                                                    change ->
//                                                category.attributes[index].setValue(change)
//                                            })
//                                    }
//                                }
//
//                                is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> {
//                                    CardTextField(category.attribute.returnValue(),
//                                        {
//                                            change ->
//                                            //card = card.copy(cardAttributes = card.cardAttributes.toMutableList().also { it[i] = card.cardAttributes.get(i).copy(attributes = listOf(category.attribute.copy(value = change)))})
//                                        })
//                                }
//
//                                is ModifiableCustomCategory.ModifiableCardsCategory -> {}
//                            }
//                        }
//                        Spacer(modifier = Modifier.height(8.dp))
//                    }
//                    /*Button(
//                        onClick = { card = card.copy(cardAttributes = card.cardAttributes.toMutableList().also { it.add(
//                            ModifiableCustomCategory.ModifiableMultiAttributesCategory.default()) } )},
//                        content = { Text("Add category") }
//                    )*/
//                }
//            }
//        }
//
//         else -> {
//
//         }
//    }
//}