package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val outputArray = mutableListOf<String>()
        var indexes = 0

        inputString.forEach {
            when (it) {
                '[' -> {
                    var endIndex = 0
                    for (i in indexes..inputString.lastIndex) {
                        var flag = false
                        when {
                            inputString[i] == ']' -> {
                                endIndex = i
                                flag = true
                            }
                        }
                        if (flag) break
                    }
                    val str = inputString.substring(indexes + 1 until endIndex)
                    outputArray.add(str)
                }
                '(' -> {
                    var endIndex = 0
                    for (i in indexes..inputString.lastIndex) {
                        var flag = false
                        when {
                            inputString[i] == ')' -> {
                                endIndex = i
                                flag = true
                            }
                        }
                        if (flag) break
                    }
                    val str = inputString.substring(indexes + 1 until endIndex)
                    outputArray.add(str)
                }
                '<' -> {
                    var endIndex = 0
                    val currentIndex = indexes
                    var next = false
                    for (i in indexes..inputString.lastIndex) {
                        var flag = false
                        when {
                            inputString[i] == '<' && currentIndex < i -> {
                                next = true
                            }
                            inputString[i] == '>' -> {
                                if (!next) {
                                    endIndex = i
                                    flag = true
                                } else {
                                    next = false
                                }
                            }
                        }
                        if (flag) break
                    }
                    val str = inputString.substring(indexes + 1 until endIndex)
                    outputArray.add(str)
                }
            }
            indexes++
        }

        return outputArray.toTypedArray()
    }
}
