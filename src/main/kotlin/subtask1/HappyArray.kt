package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyArray = sadArray.toMutableList()

        do {
            changeToHappy(happyArray)
        } while (isHappyArray(happyArray))

        return happyArray.toIntArray()
    }

    private fun isHappyArray(array: MutableList<Int>): Boolean {
        var isHappy = false
        val size = array.size - 2
        for (i in 0..size) {
            when (i) {
                in 1..array.size - 2 -> {
                    val sum = array[i - 1] + array[i + 1]
                    if (array[i] > sum) {
                        isHappy = true
                    }
                }
            }
        }
        return isHappy
    }

    private fun changeToHappy(array: MutableList<Int>): MutableList<Int> {
        val size = array.size - 2
        for (i in 0..size) {
            when (i) {
                in 1..array.size - 2 -> {
                    val sum = array[i - 1] + array[i + 1]
                    if (array[i] > sum) {
                        array.remove(array[i])
                    }
                }
            }
        }
        return array
    }
}