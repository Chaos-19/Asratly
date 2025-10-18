package com.chaos.asratly.util;


object CurrencyConverter {
    // Simulated exchange rates (replace with API call or database in production)
    private val exchangeRates = mutableMapOf(
        Pair("USD", "ETB") to 110.0, // Example: 1 USD = 110 ETB
        Pair("ETB", "USD") to 0.00909 // Example: 1 ETB = 0.00909 USD
    )

    // Fetch or calculate exchange rate (simplified)
    fun convert(amount: Double, fromCurrency: String, toCurrency: String): Double {
        if (fromCurrency == toCurrency) return amount
        val rateKey = Pair(fromCurrency, toCurrency)
        val reverseRateKey = Pair(toCurrency, fromCurrency)
        val rate = exchangeRates[rateKey] ?: (1 / exchangeRates[reverseRateKey]!!)
        return amount * rate
    }

    // Update rates (e.g., from API)
    fun updateRate(from: String, to: String, rate: Double) {
        exchangeRates[Pair(from, to)] = rate
    }
}