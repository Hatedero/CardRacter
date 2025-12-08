package com.retardero.cardracter.collections.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.retardero.cardracter.R
import com.retardero.cardracter.app.components.CardSubTitleTextField
import com.retardero.cardracter.app.components.CardTextField
import com.retardero.cardracter.app.components.CardTitleTextField
import com.retardero.cardracter.app.components.EditTopBar
import com.retardero.cardracter.app.model.Card
import com.retardero.cardracter.app.components.FloatingActionMenuEditCard
import com.retardero.cardracter.app.database.dao.cardDAO
import com.retardero.cardracter.app.model.CustomAttribute
import com.retardero.cardracter.app.model.CustomCategory
import com.retardero.cardracter.collections.model.ModifiableCard
import com.retardero.cardracter.collections.model.ModifiableCustomAttribute
import com.retardero.cardracter.collections.model.ModifiableCustomCategory
import com.retardero.cardracter.homepage.domain.IndexViewModel
import com.retardero.cardracter.homepage.domain.ModifyCardViewModel
import com.retardero.cardracter.ui.theme.Background
import com.retardero.cardracter.ui.theme.Primary

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Destination
@Composable
fun NewCardScreen(
    navigator: DestinationsNavigator,
    viewModel: ModifyCardViewModel = viewModel(),
    cardId: Int,
    cardType: Int,
) {
    val activeCard by viewModel.activeCard.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCard(cardId, cardType)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionMenuEditCard({
                viewModel.saveCard(viewModel.activeCard.value)
            }, {
                navigator.navigateUp()
            })
        },
        topBar = {
            EditTopBar(
                { navigator.navigateUp() },
                { }
            )
        },
        modifier = Modifier
            .padding(16.dp)
            .background(Background)
    ) {
        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            item {
                when (activeCard) {
                    is ModifiableCard.ModifiableMultiCategoryCard -> {

                        Column() {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.artorias),
                                    contentDescription = "icon",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(10.dp))
                                        .fillMaxHeight()
                                        .clickable { }
                                )
                            }
                            Column(
                                Modifier.fillMaxSize(),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    CardTitleTextField(
                                        (activeCard as ModifiableCard.ModifiableMultiCategoryCard).cardTitle,
                                        { viewModel.updateTitle(it) })
                                    Spacer(modifier = Modifier.height(8.dp))
                                }

                                Spacer(modifier = Modifier.height(32.dp))

                                (activeCard as ModifiableCard.ModifiableMultiCategoryCard).cardAttributes.forEach { category ->
                                    CategoryComposable(category, viewModel)
                                }

                                Spacer(modifier = Modifier.height((32.dp)))

                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    IconButton(
                                        onClick = { viewModel.addNewCategory() },
                                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = "icon",
                                            tint = Primary
                                        )
                                    }
                                }
                            }
                        }
                    }

                    else -> {

                    }
                }
            }
        }
    }
}

@Composable
fun AttributeComposable(attribute: ModifiableCustomAttribute, viewModel: ModifyCardViewModel) {
    return when (attribute) {
        is ModifiableCustomAttribute.ModifiableTextAttribute -> {
            CardTextField(attribute.value, { viewModel.updateAttributeValue(it, attribute.id)})
        }

        is ModifiableCustomAttribute.ModifiableNumberAttribute -> {
            CardTextField(attribute.value.toString(), {})
        }

        is ModifiableCustomAttribute.ModifiableCardAttribute -> {
            CardTextField(attribute.value.toString(), {})
        }
    }
}

@Composable
fun CategoryComposable(category: ModifiableCustomCategory, viewModel: ModifyCardViewModel) {
    return when (category) {
        is ModifiableCustomCategory.ModifiableCardsCategory -> {
            CardSubTitleTextField(category.title, { viewModel.updateCategoryTitle(it, category.id) })
            category.cards.forEach { card ->
                AttributeComposable(card, viewModel)
            }
        }

        is ModifiableCustomCategory.ModifiableMultiAttributesCategory -> {
            CardSubTitleTextField(category.title, { viewModel.updateCategoryTitle(it, category.id) })
            category.attributes.forEach { card ->
                AttributeComposable(card, viewModel)
            }
            IconButton(
                onClick = { viewModel.addNewAttribute(category.id) },
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "icon",
                    tint = Primary
                )
            }
        }

        is ModifiableCustomCategory.ModifiableSingleAttributeCategory -> {
            CardSubTitleTextField(category.title, { viewModel.updateCategoryTitle(it, category.id) })
            AttributeComposable(category.attribute, viewModel)
        }
    }
}