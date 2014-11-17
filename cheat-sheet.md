#Scala, pourquoi et pourquoi pas

##Langage objet

###Déclaration
	:load 01-declaration.sc
* new class
* type annotation
* def , var, val, lazy val
* AnyVal, AnyRef

###Classe
	:load 02-classe.sc
* classe avec paramètre
* pas de getter,setter pour l'instant
* mais on peut l'utiliser en interne, ex avec toString
* val, var pour des fields

###case class
	:load 03-case-class.sc
* case class
* toString, hashcode, copy
* Serializable

Montant et méthode + => coincé par devise

###trait
	:load 04-trait-object.sc
trait + object NaN + Pattern matching


###object companion
	:paste 05-companion.sc
	
Factory method

##λ
###Algebric data type
	:paste 06.adt

###sealed trait + pattern matching
	:paste 07-sealed-trait.sc
	
	def affiche(montant: Montant) = montant match{
    	case Valide(v,d) => println(s"$v $d")
     	case Zero => println("Ø")
    }
    
###Collections

	:load 08-collections.sc
	  
###lambdas
	:load 09-lambda.sc

##Sugar, sugar, sugar

###PRODUCTION: _
Lambas

	:load 10-_.sc

###PRODUCTION: for comprehension

	:load 11-for.sc	


###PRODUCTION: Infix
	:load 12-infix.sc
	
	
###PRODUCTION: Methods with symbols
	:paste 13-symbol.sc


###TEST: Default parameter value
	:paste 14-default-param-value.sc
		
###TEST: Implicit conversion
	:paste 15-implicit-conversion.sc

	:implicits
		
###TEST: Implicit classes
	:paste 16-implicit-class.sc	
