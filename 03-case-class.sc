case class Montant(valeur:Double, devise: String)

//Génération du toString
new Montant(15,"EUR")

//Génération du equals
new Montant(15,"EUR") == new Montant(15,"EUR")
//mais ce sont bien deux instances séparées
new Montant(15,"EUR") eq new Montant(15,"EUR")

//Génération d'une factory methode
Montant(15,"EUR")

//Serializable
Montant(15,"EUR").isInstanceOf[Serializable]

Montant(15,"EUR").copy(devise = "USD")
