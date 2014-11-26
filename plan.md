# Scala

##Langage objet

###01-declaration.sc

* class Montant
* def, var, val

###02-classe.sc

* class Montant(valeur: Double)
* toString

###03-case-class.sc

* toString
* copy
* serializable
* hashCode / equals

###04-trait-object.sc

* trait Montant
* extends
* object NaN

###05-companion.sc

* factory method
* static code

##λ

###06.adt

* algebric data type
* pattern matching

###07-sealed-trait.sc

* afficheMontant
* sealed-trait = compilation

###08-collections.sc

* map, flatMap, filter
* take, drop, sliding, grouped
* Stream
* Range

###09-lambda.sc

* (i: Int ) => i + 1
* i => i + 1
* val f = (i: Int) => i + 1
* f.apply(1)
* f(1)
* Predicate

##Sugar, sugar, sugar

###10-_.sc

* map(i => i + 1 )
* map(_ + 1)
* map(_.toString)
* Pattern Matching

###11-for.sc	

* for List, Try, Future

###12-infix.sc

* Montant(..) plus Montant(..)
	
###13-symbol.sc

* Montant(..) + Montant(..)

###14-default-param-value.sc

* def unMontant(valeur: Double= 10 , devise: String = "EUR")
		
###15-implicit-conversion.sc

* implicit def toCurrency(devise: String): Currency = ...
		
###16-implicit-class.sc	

* implicit class DoublePourMontant(valeu..) { def EUR: Montant ... }
