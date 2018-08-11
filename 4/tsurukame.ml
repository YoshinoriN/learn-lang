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
*)

