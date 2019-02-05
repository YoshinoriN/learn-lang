(*
  Calc absolute value
  getAbsoluteValue float -> float
*)
let getAbsoluteValue x =
  if x > 0.0 then
    x
  else
    -. x

(* Unit test *)
let test1 = getAbsoluteValue 0.0 = 0.0
let test2 = getAbsoluteValue 2.1 = 2.1
let test2 = getAbsoluteValue (-2.1) = 2.1

(*
  #use "abs.ml";;

  Result
  val getAbsoluteValue : float -> float = <fun>
  val test1 : bool = true
  val test2 : bool = true
  val test2 : bool = true
*)
