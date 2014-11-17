def unMontant(valeur: Double = 0d, devise: String = "EUR"): Montant = 
   Montant(valeur,devise)

val x = unMontant()
val y = unMontant(devise = "USD")
val z = unMontant(valeur = 10d)
val t = unMontant(10d)
val u = unMontant(10d,"EUR")
