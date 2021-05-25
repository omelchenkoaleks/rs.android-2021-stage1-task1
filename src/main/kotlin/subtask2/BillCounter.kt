package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val priceForAnna = (getCostMeal(bill, k) / 2)

        return when {
            priceForAnna == b -> {
                "Bon Appetit"
            }
            b > priceForAnna -> {
                (b - priceForAnna).toString()
            }
            else -> "Unknown price"
        }
    }

    private fun getCostMeal(bill: IntArray, k: Int): Int {
        val cost = bill.toMutableList()
        cost.remove(bill[k])
        return cost.toList().sum()
    }
}
