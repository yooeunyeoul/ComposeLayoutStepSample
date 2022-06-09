package com.dongeul.composelayoutstepsample

import android.graphics.drawable.BitmapDrawable
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.dongeul.composelayoutstepsample.ui.theme.ComposeLayoutStepSampleTheme
import org.w3c.dom.Text
import java.util.*

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth()
    )
}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    // Implement composable here
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )

    }
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @DrawableRes drawable: Int

) {
    // Implement composable here
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.width(192.dp)
        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = text),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

    }

}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    // Implement composable here
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
//        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(
                drawable = item.drawable,
                text = item.text
            )
        }
    }
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Implement composable here

    LazyHorizontalGrid(
        rows = GridCells.Fixed(count = 2),
        modifier = modifier.height(120.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(text = item.text, drawable = item.drawable)
        }
    }


}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Implement composable here
    Column(modifier = modifier) {
        Text(
            stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Implement composable here

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = modifier.height(16.dp))
    }

}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    // Implement composable here
    BottomNavigation(modifier = modifier,
    backgroundColor = MaterialTheme.colors.background) {
        BottomNavigationItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Face, contentDescription = null) },
            label = { Text(stringResource(id = R.string.bottom_navigation_home)) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AccountBox, contentDescription = null) },
            label = { Text(stringResource(id = R.string.bottom_navigation_profile)) }
        )
    }
}

// Step: MySoothe App - Scaffold
@Composable
fun MySootheApp() {
    // Implement composable here
    Scaffold(
        bottomBar = { SootheBottomNavigation()}
    ) {padding->
        HomeScreen()
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    ComposeLayoutStepSampleTheme { SearchBar(Modifier.padding(8.dp)) }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    ComposeLayoutStepSampleTheme {
        AlignYourBodyElement(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    ComposeLayoutStepSampleTheme {
        FavoriteCollectionCard(
            modifier = Modifier.padding(8.dp),
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPreview() {
    ComposeLayoutStepSampleTheme { FavoriteCollectionsGrid() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    ComposeLayoutStepSampleTheme { AlignYourBodyRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    ComposeLayoutStepSampleTheme {
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ScreenContentPreview() {
    ComposeLayoutStepSampleTheme { HomeScreen() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavigationPreview() {
    ComposeLayoutStepSampleTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun MySoothePreview() {
    MySootheApp()
}
