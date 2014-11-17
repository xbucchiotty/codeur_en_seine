//Déclarer une class
class Montant

//méthode qui évalue new Montant à chaque appel
def a = new Montant

//variable muable b pour un montant
var b = new Montant
b = new Montant

//variable immuable c pour un montant
val c = new Montant
//c = new Montant ne compile pas

//Variable immuable mais évaluée tardivement
lazy val d = {println("Évaluation");new Montant}
//rien ne s'affiche

d
//Évaluation

val any_1: Any = 1
val any_2: Any = new Montant

val anyVal_1:AnyVal = 1
//ne compile pas
//val anyVal_2:AnyVal = new Montant

//ne compile pas
//val anyRef_1:AnyRef = 1
val anyRef_2:AnyRef = new Montant
