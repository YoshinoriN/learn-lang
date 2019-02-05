(*
  Calc crane legs
  calcCraneLegs: int -> int
*)
let calcCraneLegs x = x * 2

(* Unit test *)
let ctest1 = calcCraneLegs 2 = 4
let ctest2 = calcCraneLegs 3 = 6
let ctest3 = calcCraneLegs 0 = 0

(*
  Calc turtle legs
  calcTurtleLegs: int -> int
*)
let calcTurtleLegs x = x * 4

(* Unit test *)
let ttest1 = calcTurtleLegs 2 = 8
let ttest2 = calcTurtleLegs 3 = 12
let ttest3 = calcTurtleLegs 0 = 0

(*
  Calc legs
  calcLegs: int -> int -> int
*)
let calcLegs cranes turtles = (calcCraneLegs cranes) + (calcTurtleLegs turtles)

(* Unit test *)
let test1 = calcLegs 2 0 = 4
let test2 = calcLegs 0 2 = 8
let test3 = calcLegs 2 2 = 12
let test3 = calcLegs 3 3 = 18

(*
  Get number of cranes by legs
  getNumberOfCranesFromLegs: int -> int
*)
let getNumberOfCranesFromLegs legs = legs / 2
(* Unit test *)
let nctest1 = getNumberOfCranesFromLegs 2 = 1
let nctest2 = getNumberOfCranesFromLegs 3 = 1
let nctest2 = getNumberOfCranesFromLegs 4 = 2

(*
  Get number of turtles by legs
  getNumberOfTurtleFromLegs: int -> int
*)
let getNumberOfTurtleFromLegs legs = legs / 4

(* Unit test *)
let nttest1 = getNumberOfTurtleFromLegs 4 = 1
let nttest2 = getNumberOfTurtleFromLegs 7 = 1
let nttest2 = getNumberOfTurtleFromLegs 8 = 2

(*
  Calc crane from number of cranes and turtles with them legs
  calcCrane: int -> int -> int
*)
let calcCrane cranesAndTurtles legs = getNumberOfCranesFromLegs ((calcTurtleLegs cranesAndTurtles) - legs)

(* Unit test *)
let cstest1 = calcCrane 10 40 = 0
let cstest2 = calcCrane 10 36 = 2
let cstest2 = calcCrane 10 28 = 6

(*
  #use "tsurukame.ml";;

  Result
  val calcCraneLegs : int -> int = <fun>
  val ctest1 : bool = true
  val ctest2 : bool = true
  val ctest3 : bool = true
  val calcTurtleLegs : int -> int = <fun>
  val ttest1 : bool = true
  val ttest2 : bool = true
  val ttest3 : bool = true
  val calcLegs : int -> int -> int = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test3 : bool = true
  val getNumberOfCranesFromLegs : int -> int = <fun>
  val nctest1 : bool = true
  val nctest2 : bool = true
  val nctest2 : bool = true
  val getNumberOfTurtleFromLegs : int -> int = <fun>
  val nttest1 : bool = true
  val nttest2 : bool = true
  val nttest2 : bool = true
  val calcCrane : 'a -> int -> int = <fun>
  val cstest1 : bool = false
  val cstest2 : bool = false
  val cstest2 : bool = false
  # #use "tsurukame.ml";;
  val calcCraneLegs : int -> int = <fun>
  val ctest1 : bool = true
  val ctest2 : bool = true
  val ctest3 : bool = true
  val calcTurtleLegs : int -> int = <fun>
  val ttest1 : bool = true
  val ttest2 : bool = true
  val ttest3 : bool = true
  val calcLegs : int -> int -> int = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test3 : bool = true
  val test3 : bool = true
  val getNumberOfCranesFromLegs : int -> int = <fun>
  val nctest1 : bool = true
  val nctest2 : bool = true
  val nctest2 : bool = true
  val getNumberOfTurtleFromLegs : int -> int = <fun>
  val nttest1 : bool = true
  val nttest2 : bool = true
  val nttest2 : bool = true
  val calcCrane : int -> int -> int = <fun>
  val cstest1 : bool = true
  val cstest2 : bool = true
  val cstest2 : bool = true
*)

