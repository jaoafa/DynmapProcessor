package markers

import MinecraftCoordinate
import kotlinx.serialization.Serializable

typealias LineMarker = Pair<MinecraftCoordinate, MinecraftCoordinate>

@Serializable
data class Markers(
    val markers: List<Marker>
)


@Serializable
data class Marker(
    val type: MarkerType,
    val name: String,
    val coordinates: List<MinecraftCoordinate>,
    val radius: Int = 3,
    val color: Color,
    val overlay: Color
)

@Serializable
enum class MarkerType {
    Area, Line, Circle
}

@Serializable
data class Color(
    val r: Int,
    val g: Int,
    val b: Int,
    val a: Int = 100
) {
    init {
        if (!(r in 0..255 && g in 0..255 && b in 0..255 && a in 0..100))
            throw IllegalArgumentException("RGB value must be in the range of 0 to 255, and alpha is 0 to 100.")
    }

    fun toJavaColor() = java.awt.Color(r, g, b, a)
}