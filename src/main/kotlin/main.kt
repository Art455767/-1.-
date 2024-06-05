fun main() {
    println(agoToText(55)) // "был(а) только что"
    println(agoToText(120)) // "был(а) 2 минуты назад"
    println(agoToText(3600)) // "был(а) 1 час назад"
    println(agoToText(86400)) // "был(а) вчера"
    println(agoToText(172800)) // "был(а) позавчера"
    println(agoToText(259201)) // "был(а) давно"
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..3600 -> minutesAgo(seconds)
        in 3601..86400 -> hoursAgo(seconds)
        in 86401..172800 -> "был(а) вчера"
        in 172801..259200 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

private fun minutesAgo(seconds: Int): String {
    val minutes = seconds / 60
    return when (minutes) {
        1, 21, 31, 41, 51 -> "$minutes минуту назад"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

private fun hoursAgo(seconds: Int): String {
    val hours = seconds / 3600
    return when (hours) {
        1, 21 -> "$hours час назад"
        in 2..4, in 22..24 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}