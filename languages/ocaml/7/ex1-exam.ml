(*
  Calc average of examination
  int -> int -> int -> int -> int -> int
*)
let ave nationalLang mathmatics english science society = (nationalLang + mathmatics + english + science + society) / 5

(*
  Calc sum of examination
  int -> int -> int -> int -> int -> int
*)
let sum nationalLang mathmatics english science society = nationalLang + mathmatics + english + science + society

(*
  Calc sum and average of examination
  int -> int -> int -> int -> int -> (int * int)
*)
let sumAndAve nationalLang mathmatics english science society =
  (
    sum nationalLang mathmatics english science society,
    ave nationalLang mathmatics english science society
  )

(* Unit test *)
let sumTest = sum 78 95 68 39 98 = 378
let aveTest = ave 78 95 68 39 98 = 75
let sumAndAveTest = sumAndAve 78 95 68 39 98 = (378, 75)

(*
  #use "ex1-exam.ml";;

  Result
  ------------------------------------
  val ave : int -> int -> int -> int -> int -> int = <fun>
  val sum : int -> int -> int -> int -> int -> int = <fun>
  val sumAndAve : int -> int -> int -> int -> int -> int * int = <fun>
  val sumTest : bool = true
  val aveTest : bool = true
  val sumAndAveTest : bool = true
*)
