package com.retardero.cardracter.data.attribute

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class LongTextAttribute(
    title: String? = null,
    text: String?) : CustomAttribute(title) {
        var text: String? = text

    companion object {
        fun testData(): LongTextAttribute = LongTextAttribute(
            text = "Artorias the Abysswalker, once a noble and valiant knight, was one of the Four Knights of Gwyn, Lord of Sunlight. Renowned for his unparalleled swordsmanship and stoic nature, Artorias' reputation was built upon countless victories in battle and his unyielding commitment to the Light. His greatest test came when the Abyss, a swirling void of dark, corrupting power, began to spread across the lands. At the time, the kingdom was on the brink of collapse, and Artorias was chosen to lead a final stand against the encroaching darkness. Armed with his legendary Greatsword, and accompanied by his loyal companion, Sif, a great grey wolf, Artorias ventured into the heart of the Abyss, where few dared to tread.\n" +
                    "\n" +
                    "The battle was brutal, with Artorias fighting fiercely against the creeping darkness that threatened to consume the world. However, the Abyss was a force unlike any other, and even Artorias, with all his skill and strength, was ultimately overwhelmed. The corruption of the Abyss twisted and broke his body, leaving him crippled and deformed. His sword arm was shattered, and the once-proud knight was forced to use his weakened limbs to defend himself. In a desperate act of self-sacrifice, Artorias used his remaining strength to hold back the Abyss long enough for others to escape, knowing he would be left to perish in its depths.\n" +
                    "\n" +
                    "When the world later came to know of his fate, the legend of Artorias took on a tragic hue. His battle against the Abyss was not just a physical one, but a spiritual one, as he had unknowingly embraced the very corruption he sought to destroy. He became a fallen hero, a symbol of lost hope, fighting in the Abyss for an eternity as the very darkness he once fought against consumed him. In his final moments, Artorias became a cautionary tale, a reminder of the price one pays for defying the inevitability of the dark. Yet, his name endured, as those who remembered his sacrifice continued to speak of the brave knight who stood alone against the end of the world."
        )
    }

    @Composable
    override fun draw() {
        return Column (

        ) {
            Text("$text")
        }
    }
}