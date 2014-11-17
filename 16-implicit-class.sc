implicit class SuperDouble(val valeur: Double) extends AnyVal {

   def EUR = Montant(valeur, "EUR")

   def USD = Montant(valeur, "USD")

}

15.EUR
